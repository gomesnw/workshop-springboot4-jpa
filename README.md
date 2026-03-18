# Projeto Spring Boot API - Sistema de Gerenciamento de Usuários e Pedidos.

Este é um projeto de estudo desenvolvido para consolidar conhecimentos em **Java**, **Spring Boot** e arquitetura de sistemas **RESTful**. O objetivo principal foi implementar um back-end robusto, com persistência em banco de dados e tratamento de exceções customizado.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Acesso a Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 (Desenvolvimento) / MySQL (Produção)
* **Documentação:** Swagger (OpenAPI 3)
* **Gerenciador de Dependências:** Maven

## 🛠️ Funcionalidades e Aprendizados

Durante o desenvolvimento deste projeto, foram explorados conceitos fundamentais do ecossistema Spring:

* **Camadas do Sistema:** Implementação seguindo o padrão *Resource-Service-Repository*.
* **Mapeamento Objeto-Relacional (ORM):** Relacionamentos Um-para-Muitos e Muitos-para-Muitos entre Entidades.
* **Tratamento de Exceções:** Criação de exceções personalizadas (ex: `ResourceNotFoundException`) e um manipulador global (`StandardError`) para respostas JSON limpas.
* **Data Transfer Objects (DTO):** Utilização de DTOs para tráfego de dados e segurança da API.
* **Seeding de Banco de Dados:** Configuração de um perfil de teste para popular o banco automaticamente ao iniciar a aplicação.

## 📖 Documentação da API (Swagger)

A documentação interativa da API foi implementada com o **Swagger UI**. Nela, é possível visualizar todos os endpoints, modelos de dados e realizar testes de requisições.

Para acessar a documentação (com o projeto rodando localmente):
> `http://localhost:8080/swagger-ui.html`

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
    mvn spring-boot:run
    ```

---

## 👨‍💻 Sobre o Autor

Desenvolvido por **Isaque Gomes** - Estudante de Engenharia de Software na UEPA.
* [LinkedIn](https://www.linkedin.com/in/gomesnw)
* [GitHub](https://github.com/gomesnw)
