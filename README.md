# Fintech Backend

Sistema de gerenciamento financeiro desenvolvido como projeto da FIAP.

## 📋 Descrição

API REST para gestão financeira pessoal, permitindo controle de contas bancárias, transações e categorização de despesas. Desenvolvido com Java 21, Spring Boot e Oracle Database, oferecendo endpoints para gerenciamento completo de usuários, bancos, agências e movimentações financeiras.

## 🚀 Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.7** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **Spring Validation** - Validação de dados
- **Spring Security** - Segurança, autenticação e autorização de usuários
- **Oracle JDBC Driver (ojdbc11)** - Conexão com Oracle Database
- **Lombok** - Redução de código repetitivo
- **Spring Boot DevTools** - Automatização da reinicialização da aplicação durante desenvolvimento

## 📦 Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- **Java Development Kit (JDK) 21** ou superior
  - Verifique a instalação: `java -version`
  - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://adoptium.net/)

- **Maven 3.6+** (opcional, o projeto inclui Maven Wrapper)
  - Verifique a instalação: `mvn -version`
  - Download: [Apache Maven](https://maven.apache.org/download.cgi)

- **Oracle Database** (acesso ao servidor)
  - O projeto está configurado para conectar a um banco Oracle
  - Certifique-se de ter as credenciais corretas

- **Git** (para clonar o repositório)
  - Verifique a instalação: `git --version`
  - Download: [Git](https://git-scm.com/downloads)

## 🚀 Instruções de Inicialização

### 1. Configurar o Banco de Dados

Edite o arquivo `src/main/resources/application.properties` com suas credenciais:

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

⚠️ **Importante**: Não commite suas credenciais no repositório!

### 2. Instalar Dependências

O projeto utiliza Maven Wrapper, então não é necessário ter Maven instalado globalmente.

#### No Windows (PowerShell):
```powershell
.\mvnw.cmd clean install
```

#### No Linux/Mac:
```bash
./mvnw clean install
```

Ou, se tiver Maven instalado:
```bash
mvn clean install
```

### 3. Executar o Projeto

#### Opção 1: Usando Maven Wrapper (Windows)
```powershell
.\mvnw.cmd spring-boot:run
```

#### Opção 2: Usando Maven Wrapper (Linux/Mac)
```bash
./mvnw spring-boot:run
```

#### Opção 3: Usando Maven (se instalado)
```bash
mvn spring-boot:run
```

#### Opção 4: Executando o JAR compilado
```bash
java -jar target/fintech-0.0.1-SNAPSHOT.jar
```

### 4. Verificar se está funcionando

Após iniciar o projeto, a aplicação estará disponível em:
```
http://localhost:8080
```

Você deverá ver logs no console indicando que a aplicação foi iniciada com sucesso:
```
Started FintechApplication in X.XXX seconds
```

## 📁 Estrutura do Projeto

```
fintech-backend/
├── src/
│   ├── main/
│   │   ├── java/br/com/fiap/fintech/
│   │   │   ├── config/ 
│   │   │   │   └── CorsConfiguration.java    # Configuração CORS
│   │   │   ├── controller/               # Controllers REST
│   │   │   ├── dto/                      # Data Transfer Objects
│   │   │   ├── model/                    # Entidades JPA
│   │   │   ├── repository/               # Repositórios JPA
│   │   │   ├── security/                 # Configurações de Segurança
│   │   │   ├── service/                  # Lógica de negócio
│   │   │   └── FintechApplication.java
│   │   └── resources/
│   │       ├── application.properties        # Configurações principais
│   │       └── ValidationMessages.properties # Mensagens de validação personalizadas
│   └── test/                             # Testes unitários
│       └── application-test.properties       # Configurações de teste              
├── pom.xml                             # Configuração Maven
└── README.md                           # Este arquivo
```

## 🔧 Comandos Úteis

### Compilar o projeto
```bash
.\mvnw.cmd clean compile
```

### Executar testes
```bash
.\mvnw.cmd test
```

### Gerar pacote JAR
```bash
.\mvnw.cmd clean package
```

### Limpar build anterior
```bash
.\mvnw.cmd clean
```

## 📝 Endpoints da API

A API está disponível no prefixo `/api` e oferece os seguintes recursos:

### Autenticação
- `POST /api/auth/register` - Registrar novo usuário
- `POST /api/auth/login` - Autenticar usuário

### Usuários
- `GET /api/users` - Listar todos os usuários
- `GET /api/users/{id}` - Obter usuário por ID
- `PUT /api/users/{id}` - Atualizar dados do usuário
- `DELETE /api/users/{id}` - Deletar usuário
- `GET /api/users/{id}/transactions` - Listar transações do usuário
- `GET /api/users/{id}/bank-accounts` - Listar contas bancárias do usuário

### Bancos
- `POST /api/banks` - Criar novo banco
- `GET /api/banks` - Listar todos os bancos
- `GET /api/banks/{id}` - Obter banco por ID
- `PUT /api/banks/{id}` - Atualizar dados do banco
- `DELETE /api/banks/{id}` - Deletar banco

### Agências
- `POST /api/branches` - Criar nova agência
- `GET /api/branches` - Listar todas as agências
- `GET /api/branches/{id}` - Obter agência por ID
- `PUT /api/branches/{id}` - Atualizar dados da agência
- `DELETE /api/branches/{id}` - Deletar agência

### Contas Bancárias
- `POST /api/bank-accounts` - Criar nova conta bancária
- `GET /api/bank-accounts` - Listar todas as contas bancárias
- `GET /api/bank-accounts/{id}` - Obter conta bancária por ID
- `PUT /api/bank-accounts/{id}` - Atualizar dados da conta bancária
- `DELETE /api/bank-accounts/{id}` - Deletar conta bancária
- `GET /api/bank-accounts/{id}/transactions` - Listar transações da conta

### Transações
- `POST /api/transactions` - Registrar nova transação
- `GET /api/transactions` - Listar todas as transações
- `GET /api/transactions/{id}` - Obter transação por ID
- `PUT /api/transactions/{id}` - Atualizar dados da transação
- `DELETE /api/transactions/{id}` - Deletar transação

### Tipos de Transação
- `POST /api/transaction-types` - Criar novo tipo de transação
- `GET /api/transaction-types` - Listar todos os tipos de transação
- `GET /api/transaction-types/{id}` - Obter tipo de transação por ID
- `PUT /api/transaction-types/{id}` - Atualizar tipo de transação
- `DELETE /api/transaction-types/{id}` - Deletar tipo de transação

### Categorias de Transação
- `POST /api/transaction-categories` - Criar nova categoria de transação
- `GET /api/transaction-categories` - Listar todas as categorias de transação
- `GET /api/transaction-categories/{id}` - Obter categoria de transação por ID
- `PUT /api/transaction-categories/{id}` - Atualizar categoria de transação
- `DELETE /api/transaction-categories/{id}` - Deletar categoria de transação
