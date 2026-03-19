# Projeto Spring Boot API - Sistema de Gerenciamento de Usuários e Pedidos.

API REST desenvolvida com Java + Spring Boot para gerenciamento de usuários e pedidos, com persistência em banco de dados e boas práticas de arquitetura backend.

Este projeto foi desenvolvido com foco em consolidar conceitos fundamentais de desenvolvimento de APIs RESTful utilizando o ecossistema Spring.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Acesso a Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** PostgreSQL (Neon)
* **Documentação:** Swagger/OpenAPI
* **Gerenciador de Dependências:** Maven

## 📌 Funcionalidades

- CRUD completo de usuários e pedidos  
- Relacionamentos entre entidades (One-to-Many / Many-to-Many)  
- Validação de dados com Bean Validation  
- Uso de DTOs para encapsulamento e segurança dos dados  
- Tratamento global de exceções  
- Documentação interativa com Swagger

## 🧠 Conceitos Aplicados

- Arquitetura em camadas (Controller → Service → Repository)  
- Mapeamento Objeto-Relacional (ORM) com JPA/Hibernate  
- Boas práticas de APIs REST  
- Separação entre entidades e DTOs  
- Tratamento padronizado de erros  

  
## 📖 Documentação da API (Swagger)

A documentação interativa da API foi implementada com o **Swagger UI**. Nela, é possível visualizar todos os endpoints, modelos de dados e realizar testes de requisições.

Para acessar a documentação (com o projeto rodando localmente):
> `http://localhost:8080/swagger-ui.html`

## ⚙️ Configuração do Banco de Dados

O projeto pode ser executado de duas formas:

### 1. Ambiente local com H2
Para testes rápidos e execução local, o projeto pode utilizar o banco em memória H2, sem necessidade de configuração adicional.

### 2. Ambiente com PostgreSQL
Para utilizar PostgreSQL, configure as seguintes variáveis de ambiente com as credenciais do seu próprio banco:

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://HOST:5432/DB?sslmode=require
SPRING_DATASOURCE_USERNAME=USER
SPRING_DATASOURCE_PASSWORD=PASSWORD
```

## 🏁 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/](https://github.com/)gomesnw/workshop-springboot4-jpa.git
    ```
2.  **Entre na pasta do projeto:**
    ```bash
    cd workshop-springboot4-jpa
    ```
3.  **Execute a aplicação via Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```
    **Ou no Windows, utilize:**
     ```bash
    mvnw.cmd spring-boot:run
     ```

---

Desenvolvido por **Isaque Gomes** - Estudante de Engenharia de Software na UEPA.
* [LinkedIn](https://www.linkedin.com/in/gomesnw)
* [GitHub](https://github.com/gomesnw)
