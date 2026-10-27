<div align="center">

# CustomerConnect

### Sistema de Gerenciamento de Clientes

**API REST para cadastro, consulta, atualização e exclusão de clientes com Spring Boot e Spring Data JPA.**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

</div>

---

## 📖 Sobre o projeto

O **CustomerConnect** é um projeto prático de desenvolvimento backend, criado para exercitar os fundamentos do **Spring Boot** e do **Spring Data JPA** por meio de uma API RESTful de gerenciamento de clientes.

A proposta é implementar operações **CRUD** (*Create, Read, Update e Delete*), persistência de dados, validação de unicidade e consultas com filtros, paginação e ordenação.

## 🎯 Objetivos de aprendizagem

- Configurar uma aplicação Spring Boot e sua conexão com um banco de dados.
- Modelar entidades e repositórios utilizando Spring Data JPA.
- Organizar regras de negócio em uma camada de serviço.
- Implementar endpoints RESTful para operações CRUD.
- Trabalhar com filtros, paginação e ordenação de resultados.
- Registrar datas de criação e atualização para auditoria.

## 🛠️ Tecnologias e ferramentas

| Tecnologia / ferramenta | Finalidade |
| --- | --- |
| **Java** | Linguagem de programação |
| **Spring Boot** | Desenvolvimento da aplicação e da API REST |
| **Spring Data JPA** | Persistência e acesso aos dados |
| **MySQL** | Banco de dados relacional utilizado como referência |
| **Docker** | Apoio à execução de serviços em contêineres |
| **Beekeeper Studio** | Administração e consulta ao banco de dados |

> **Nota:** a configuração exata das ferramentas e as versões utilizadas devem ser verificadas nos arquivos do projeto.

## 📋 Regras de negócio

### 1. Dados cadastrais

Cada cliente deve possuir as seguintes informações:

| Campo | Descrição |
| --- | --- |
| `customerId` | Identificador único do cliente |
| `fullName` | Nome completo |
| `cpf` | CPF |
| `email` | Endereço de e-mail |
| `phoneNumber` | Número de telefone celular |
| Data de criação | Data de registro do cliente no sistema |
| Data de atualização | Data da última atualização cadastral |

As datas de criação e atualização são utilizadas para fins de **auditoria**.

### 2. Cadastro único

O sistema deve impedir a existência de clientes com:

- Identificador (`customerId`) duplicado;
- CPF duplicado;
- E-mail duplicado.

### 3. Busca flexível

A consulta de clientes deve permitir:

- Filtrar por **CPF** e/ou **e-mail**;
- Paginar os resultados;
- Ordenar os registros pela **data de criação**.

## 🌐 Documentação da API

**Recurso base:** `/customers`

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `POST` | `/customers` | Cadastrar um cliente |
| `GET` | `/customers` | Consultar clientes com filtros e paginação |
| `PUT` | `/customers/{customerId}` | Atualizar os dados de um cliente |
| `DELETE` | `/customers/{customerId}` | Excluir um cliente |

### ➕ Cadastrar cliente

**`POST /customers`**

Campos obrigatórios da requisição:

| Campo | Descrição |
| --- | --- |
| `fullName` | Nome completo |
| `cpf` | CPF |
| `email` | E-mail |
| `phoneNumber` | Telefone celular |

**Exemplo de requisição:**

```http
POST /customers
Content-Type: application/json
```

```json
{
  "fullName": "Maria Oliveira",
  "cpf": "12345678909",
  "email": "maria@example.com",
  "phoneNumber": "11999999999"
}
```

**Exemplo ilustrativo de resposta:**

```json
{
  "customerId": 1
}
```

### 🔎 Consultar clientes

**`GET /customers`**

Parâmetros de consulta:

| Parâmetro | Descrição |
| --- | --- |
| `page` | Número da página |
| `pageSize` | Quantidade de registros por página |
| `orderBy` | Ordenação pela data de criação |
| `email` | Filtro por e-mail |
| `cpf` | Filtro por CPF |

**Exemplo de requisição:**

```http
GET /customers?page=0&pageSize=10&email=maria%40example.com
```

**Retorno esperado:** dados dos clientes encontrados e informações de paginação.

> Os valores aceitos em `orderBy` e o formato exato da resposta paginada dependem da implementação da API.

### ✏️ Atualizar cliente

**`PUT /customers/{customerId}`**

Campos obrigatórios:

| Campo | Descrição |
| --- | --- |
| `fullName` | Nome completo |
| `email` | E-mail |
| `phoneNumber` | Telefone celular |

**Exemplo de requisição:**

```http
PUT /customers/1
Content-Type: application/json
```

```json
{
  "fullName": "Maria Oliveira Santos",
  "email": "maria.santos@example.com",
  "phoneNumber": "11988888888"
}
```

### 🗑️ Excluir cliente

**`DELETE /customers/{customerId}`**

**Exemplo de requisição:**

```http
DELETE /customers/1
```

Remove o cliente identificado por `customerId` do cadastro.

> **Observação:** os exemplos demonstram o contrato proposto para o projeto. Códigos HTTP, mensagens de erro e detalhes de resposta devem ser conferidos na implementação.

## 🧱 Organização da aplicação

A arquitetura proposta separa responsabilidades em camadas:

```text
Controller  →  Service  →  Repository  →  Banco de Dados
   │             │             │
 API REST     Regras de      Persistência
              negócio       com JPA
```

- **Controller:** recebe e responde às requisições HTTP.
- **Service:** concentra as regras de negócio e validações.
- **Repository:** realiza as operações de persistência com Spring Data JPA.
- **Entity:** representa os dados do cliente no modelo de persistência.

## 🚀 Executando o projeto

A configuração de execução depende das versões, dependências e propriedades definidas no repositório. Em um projeto Spring Boot com **Maven Wrapper**, normalmente é possível iniciar a aplicação com:

```bash
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Antes de executar, configure a conexão com o banco de dados conforme as propriedades da aplicação. Caso o projeto utilize Gradle ou outro método de inicialização, siga os arquivos de build disponíveis no repositório.

## 📚 Materiais de referência

- [Docker — site oficial](https://www.docker.com/)
- [Beekeeper Studio — repositório no GitHub](https://github.com/beekeeper-studio/beekeeper-studio)
- [Spring Boot com MySQL — guia oficial do Spring](https://spring.io/guides/gs/accessing-data-mysql)
- [Notion — Projeto CustomerConnect (material da aula)](https://brunograna.notion.site/Projeto-CustomerConnect-4e17df8ead4b4a3692f7202c53a6f65b?pvs=4)

## ✅ Resultado esperado

Ao concluir o **CustomerConnect**, o projeto deverá demonstrar a construção de uma aplicação backend com **Spring Boot** e **Spring Data JPA**, incluindo conexão com banco de dados, entidades JPA, repositórios, camada de serviço e endpoints RESTful para gerenciamento de clientes.

---

<div align="center">

**CustomerConnect** · Projeto de estudos em desenvolvimento backend com Java e Spring Boot.

</div>
