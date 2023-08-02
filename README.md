# Projeto RhControl (Java com Spring Boot e Spring Security)

Este é o repositório do back-end de projeto Full Stack desenvolvido em Java usando Spring Boot e Spring Security. O projeto tem como objetivo gerenciar funcionários de uma empresa, permitindo o cadastro, atualização, exclusão e listagem dos funcionários, além do sistema de login e cadastro. Futuramente novas funções serão desenvolvidas.

## Pré-requisitos

Antes de executar o projeto, é necessário ter os seguintes pré-requisitos instalados em sua máquina:

- Java 11 ou superior
- Maven
- PostgreSQL

Certifique-se de que o PostgreSQL esteja configurado corretamente com um banco de dados chamado "employee". Você pode ajustar as configurações de conexão no arquivo `application.properties`.

## Instalação

Para executar o projeto, siga os seguintes passos:

1. Clone este repositório em sua máquina:
```bash
  git clone https://github.com/felstylex/Java-RhControl.git
```
2. Navegue até o diretório do projeto:
```bash
  cd RhControl
```

4. Compile e execute o projeto.
  
5. O aplicativo deve estar disponível em `http://localhost:8080`.

## API Endpoints

O projeto define os seguintes endpoints da API:

- `GET /employees`: Retorna uma lista de todos os funcionários cadastrados.
- `GET /employees/{id}`: Retorna um funcionário específico com base no ID fornecido.
- `POST /employees`: Cria um novo funcionário com os dados fornecidos.
- `PUT /employees/{id}`: Atualiza os dados de um funcionário existente com base no ID fornecido.
- `DELETE /employees/{id}`: Exclui um funcionário com base no ID fornecido.
- `POST /login`: Realiza o login na para acessar as páginas
- `POST /register`: Cadastra um novo usuário

## Front end do projeto
👉 [Link do repositório](https://github.com/felstylex/Angular-RhControl)
