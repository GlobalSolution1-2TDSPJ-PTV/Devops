# FloodWatch API - Monitoramento de Enchentes

Este é um projeto backend desenvolvido em Java com Spring Boot para fornecer uma API RESTful de monitoramento de enchentes, integrando com banco de dados Oracle XE conteinerizado via Docker.  

O objetivo é oferecer funcionalidades para cadastro, consulta, atualização e exclusão de dados relacionados a motos (Motorcycle) e demais entidades do sistema, com persistência e segurança.

---

## 👥 Integrantes do Projeto

- Pedro Henrique dos Santos - RM559064  
- Thiago Thomaz Sales Conceição - RM557992  
- Vinícius de Oliveira Coutinho - RM556182  

---

## ⚙️ Funcionalidades da API

- CRUD completo para a entidade **Motorcycle** (criar, listar, atualizar, deletar motos)
- Integração com banco Oracle XE rodando em container Docker personalizado
- Documentação da API via **Swagger UI** para testes e consulta dos endpoints
- Uso de variáveis de ambiente para configurações (banco, perfis, etc)
- Persistência dos dados com volume nomeado no Docker
- Logs acessíveis via terminal para ambos os containers (aplicação e banco)
- Execução dos containers em background via `docker-compose`

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
docker-compose up -d --build

```

## 🌐 Acessando a API
Abra no Navegador: 
```
http://localhost:8080/swagger-ui.html
```

## 🧪 Testes e Logs
Para visualizar os logs dos containers no terminal:

```
docker logs -f floodwatch-app
docker logs -f floodwatch-oracle-db
```
Para parar os containers:
```
docker-compose down
```

## 📂 Estrutura do Projeto

floodwatch/
├── src/                     # Código-fonte Java Spring Boot
├── db/
│   └── Dockerfile           # Dockerfile do Oracle XE customizado
├── Dockerfile               # Dockerfile da aplicação Java
├── docker-compose.yml       # Orquestração dos containers
├── target/                  # JAR gerado após build
├── README.md                # Documentação do projeto

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
