FROM openjdk:17-slim

# Argumento para o JAR
ARG JAR_FILE=target/FloodWatch-0.0.1-SNAPSHOT.jar

# Definindo variáveis de ambiente genéricas (valores padrão podem ser sobrescritos via docker-compose ou linha de comando)
ENV SPRING_PROFILES_ACTIVE=docker \
    SPRING_DATASOURCE_URL=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL \
    SPRING_DATASOURCE_USERNAME=RM556182 \
    SPRING_DATASOURCE_PASSWORD=101003

# Criando usuário não-root com segurança
RUN addgroup --system floodwatch && adduser --system --ingroup floodwatch floodwatch

# Criando diretório de trabalho
WORKDIR /app

# Copiando o JAR
COPY ${JAR_FILE} app.jar

# Ajustando permissões
RUN chown floodwatch:floodwatch app.jar

# Usar usuário criado
USER floodwatch

# Expondo porta da aplicação
EXPOSE 8080

# Executando a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
