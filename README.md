# Fintech Backend

Sistema de gerenciamento financeiro desenvolvido como projeto da FIAP.

## 📋 Descrição

API REST para gestão financeira pessoal, permitindo controle de contas bancárias, transações e categorização de despesas. Desenvolvido com Spring Boot, Java 21 e Oracle Database, oferecendo endpoints para gerenciamento completo de usuários, bancos, agências e movimentações financeiras.

## 🚀 Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.7** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **Spring Validation** - Validação de dados
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
spring.datasource.username=SEU_RM
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
│   │   │   ├── service/                  # Lógica de negócio
│   │   │   └── FintechApplication.java
│   │   └── resources/
│   │       └── application.properties       # Configurações principais
│   └── test/                             # Testes unitários
│       └── application-test.properties     # Configurações de teste              
├── pom.xml                               # Configuração Maven
└── README.md                             # Este arquivo
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

- `/auth` - Gerenciamento de autenticação
- `/users` - Gerenciamento de usuários
- `/banks` - Gerenciamento de bancos
- `/branches` - Gerenciamento de agências
- `/bank-accounts` - Gerenciamento de contas bancárias
- `/transactions` - Gerenciamento de transações
- `/transaction-types` - Gerenciamento de tipos de transação
- `/transaction-categories` - Gerenciamento de categorias de transação

## 🐛 Solução de Problemas

### Erro de conexão com o banco de dados
- Verifique se as credenciais no `application.properties` estão corretas
- Teste a conexão com o banco usando SQL Developer ou similar

### Erro "Java version"
- Certifique-se de ter o JDK 21 instalado
- Configure a variável de ambiente `JAVA_HOME` corretamente

### Porta 8080 já em uso
- Adicione ao `application.properties`:
  ```properties
  server.port=8081
  ```