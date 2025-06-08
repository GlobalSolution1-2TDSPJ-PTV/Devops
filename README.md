# 🌊 FloodWatch API - Sistema de Monitoramento Inteligente de Enchentes
Este é o backend do projeto FloodWatch, desenvolvido em Java com Spring Boot, que expõe uma API RESTful para monitoramento de enchentes. Ele integra-se com um banco de dados Oracle XE conteinerizado via Docker e permite o gerenciamento de diversas entidades envolvidas na resposta a desastres, como sensores, leituras ambientais, alertas, abrigos e pedidos de socorro.

O objetivo principal é fornecer uma base robusta e segura para aplicações móveis e web que atuam na prevenção, monitoramento e resposta a enchentes em áreas urbanas e periféricas.

---

## 👥 Integrantes do Projeto

Pedro Henrique dos Santos — RM559064

Thiago Thomaz Sales Conceição — RM557992

Vinícius de Oliveira Coutinho — RM556182

---

## ⚙️ Funcionalidades da API
- 📡 Integração com sensores IoT (nível da água, temperatura, umidade)

### 🌐 CRUD completo para entidades como:
- Sensor
- Leitura
- Alerta
- SOS (pedido de socorro)
- Abrigo
- Drone
- Usuário

- 🧾 Documentação interativa com Swagger UI (/swagger-ui.html)

- 🔐 Estrutura pronta para autenticação/autorização futura

- 🗃️ Banco de dados Oracle XE em container Docker, com:
Volume nomeado para persistência
Scripts de inicialização

---

## 🛠️ Tecnologias Utilizadas

- Java 17 + Spring Boot
- Spring Data JPA
- Oracle XE 21c (container personalizado)
- Docker e Docker Compose
- Swagger (Springdoc OpenAPI)
- Maven
- Lombok
- Bean Validation

---

## 🚀 Como Executar

### 1️⃣ Clonar o repositório

```
git clone https://github.com/seu-usuario/floodwatch.git
cd java
```

### 2️⃣ Build da aplicação
```
./mvnw clean package
```

### 3️⃣ Subir os containers Docker
```
docker build -t java .

docker network create minha-rede

docker run -d --name meu-oracle --network minha-rede -e ORACLE_PASSWORD=MinhaSenhaForte123 -e APP_USER=meuusuario -e APP_USER_PASSWORD=senha123 -p 1521:1521 -v oracle_data:/opt/oracle/oradata gvenzl/oracle-xe:21

docker run -d --name java-tete --network minha-rede -p 8080:8080 java
```

## 🌐 Acessando a API
Abra no Navegador: 
```
http://localhost:8080/swagger-ui.html
```

## 🧪 Testes e Logs
Para visualizar os logs dos containers no terminal:

```
docker logs meu-oracle
docker logs java-tete
```
Para parar os containers:
```
docker-compose down
```

## 📂 Estrutura do Projeto
```
floodwatch/
├── src/                     # Código-fonte Java Spring Boot
├── Dockerfile               # Dockerfile da aplicação Java
├── target/                  # JAR gerado após build
├── README.md                # Documentação do projeto
```
## ✅ Requisitos Atendidos

| Requisito                         | Status |
| --------------------------------- | :----: |
| CRUD completo da aplicação Java   |   ✅   |
| Banco Oracle em container Dockerfile|   ✅   |
| Usuário não-root configurado no DB|   ✅   |
| Porta exposta (app:8080, db:1521) |   ✅   |
| Variáveis de ambiente usadas      |   ✅   |
| Volume nomeado para persistência  |   ✅   |
| Containers rodando em background  |   ✅   |
| Testes via Swagger UI             |   ✅   |
| Logs visíveis via terminal        |   ✅   |
