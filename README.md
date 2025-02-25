# Giro.Tech - Desafio Técnico Backend

Este é um projeto de backend desenvolvido com Java e Spring Boot para o desafio técnico de criação de uma API REST que lida com dados financeiros, como moedas, taxas de câmbio, investidores e investimentos.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA** (para interação com o banco de dados)
- **PostgreSQL** (banco de dados)
- **Lombok** (para simplificar o código)
- **Spring Boot DevTools** (para facilitar o desenvolvimento)

## Funcionalidades

A API implementa os seguintes recursos:

- **Moeda**: CRUD (Create, Read, Update, Delete) de moedas.
- **Taxa de Câmbio**: CRUD de taxas de câmbio entre diferentes moedas.
- **Investidor**: CRUD de investidores.
- **Investimento**: CRUD de investimentos, associando investidores a moedas e taxas de câmbio.

## Requisitos

- **Java 17 ou superior**.
- **Banco de dados PostgreSQL** (certifique-se de ter o PostgreSQL instalado e configurado).
- **Maven** (para gerenciar as dependências).

## Configuração do Banco de Dados

Antes de executar o projeto, você precisa configurar o banco de dados PostgreSQL. Crie um banco de dados e configure as credenciais no arquivo `src/main/resources/application.properties`.

Exemplo de configuração:

```properties
spring.application.name=GiroProject
spring.datasource.url=jdbc:postgresql://localhost:5432/giro_tech_db
spring.datasource.username=postgres
spring.datasource.password=1234567
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
server.error.include-stacktrace=never
```

# Como Executar o Projeto

## Clone este repositório:

```bash
git clone https://github.com/seu-usuario/GiroProject.git

# Navegue até o diretório do projeto:

cd GiroProject

# Compile o projeto com o Maven:

mvn clean install

# Execute a aplicação:

mvn spring-boot:run
A aplicação será executada no endereço: http://localhost:8080.

```
### Testando a API
Com a aplicação em execução, você pode testar os endpoints da API com ferramentas como o Postman ou Insomnia. Abaixo estão os principais endpoints disponíveis:


#Currency API
- **GET /api/currencies**: Retorna a lista de todas as moedas.
- **POST /api/currencies**: Cria uma nova moeda.
- **GET /api/currencies/{id}**: Retorna os detalhes de uma moeda específica.
- **PUT /api/currencies/{id}**: Atualiza os dados de uma moeda existente.
- **DELETE /api/currencies/{id}**: Remove uma moeda.

#Exchange Rates API
- **GET /api/exchange-rates/recent**:Retorna taxa dos últimos 7 dias
- **POST /api/exchange-rates**: Cria uma nova taxa de câmbio.
- **GET /api/exchange-rates/{id}**: Retorna os detalhes de uma taxa de câmbio específica.
- **PUT /api/exchange-rates/{id}**: Atualiza os dados de uma taxa de câmbio existente.
- **DELETE /api/exchange-rates/{id}**: Remove uma taxa de câmbio específica.
- **DELETE /api/exchange-rates/old**: Remove as taxas de câmbio com mais de 30 dias.

#Investor API
- **GET /api/investors**: Retorna a lista de todos os investidores.
- **POST /api/investors**: Cria um novo investidor.
- **GET /api/investors/{id}**: Retorna os detalhes de um investidor específico.
- **PUT /api/investors/{id}**: Atualiza os dados de um investidor existente.
- **DELETE /api/investors/{id}**: Remove um investidor.

#Investment History API
- **GET /api/investments/{id}**: Retorna os detalhes de um investimento específico.
- **POST /api/investments**: Cria um novo investimento.


# Contribuição

Se você deseja contribuir com o projeto, siga as etapas abaixo:

1. Faça um fork deste repositório.

2. Crie uma branch com suas alterações: 
   ```bash
   git checkout -b minha-alteracao
3. Commit suas mudanças:  
   ```bash
   git commit -m 'Adicionando minha alteração'
4. Envie sua branch para o repositório remoto: 
   ```bash
   git push origin minha-alteracao.

5. Abra um pull request para revisão. 🚀









