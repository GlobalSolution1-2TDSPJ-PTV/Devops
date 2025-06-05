FROM openjdk:17-slim

# Argumento para o JAR
ARG JAR_FILE=target/FloodWatch-0.0.1-SNAPSHOT.jar

# Definindo variáveis de ambiente genéricas (valores padrão podem ser sobrescritos via docker-compose ou linha de comando)
ENV DB_HOST=meu-oracle
ENV DB_PORT=1521
ENV DB_USER=meuusuario
ENV DB_PASSWORD=senha123
ENV DB_SERVICE=/XEPDB1

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
