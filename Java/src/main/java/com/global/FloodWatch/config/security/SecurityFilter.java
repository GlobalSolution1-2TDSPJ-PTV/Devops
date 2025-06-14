package com.global.FloodWatch.config.security;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final AuthorizationService authorizationService;

    private final TokenService tokenService;

    public SecurityFilter(AuthorizationService authorizationService, TokenService tokenService) {
        this.authorizationService = authorizationService;
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token =  retornaToken(request);
        if(token != null) {
            String username = tokenService.extractUsername(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.authorizationService.loadUserByUsername(username);

                if (tokenService.isTokenValid(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private String retornaToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null) {
            return null;
        }
        return token.replace("Bearer ", "");
    }
}
