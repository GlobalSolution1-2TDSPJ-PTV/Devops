# Dockerfile (na pasta ./db)
FROM container-registry.oracle.com/database/express:21.3.0-xe

# Diretório de scripts de inicialização opcional (se você tiver .sql para executar no start)
WORKDIR /opt/oracle/scripts/startup

# (opcional) copie scripts SQL ou de configuração se necessário
# COPY init.sql .

# NÃO adicione comandos de useradd/groupadd — a imagem Oracle não permite isso
