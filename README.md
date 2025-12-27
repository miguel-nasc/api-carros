# Api de Carros 🚗 

API REST para gerenciamento de carros, desenvolvida com Java e Spring Boot, permitindo operações de cadastro, consulta, atualização e remoção de veículos.

## Funcionalidades
- Autenticar Usuário
- Renovar token de acesso
- Cadastrar um carro
- Buscar carro por ID
- Atualizar um carro
- Remover um carro
- Listar todos os carros com paginação
- Buscar carros por modelo
- Listar carros por marca
- Buscar carros por cor
- Listar carros por motor 
- Buscar carros do mesmo ano

## Tecnologias Utilizadas
- Java 21
- Spring Boot 
- Spring Web
- Spring Data JPA
- Spring Security
- MySQL
- Flyway
- JWT 
- Maven
- Swagger

## Endpoints
### Autenticação
- POST auth/signin
- POST auth/refresh
### Carros
- POST api/carros
- GET api/carros/{id}
- DELETE api/carros/{id}
- PUT api/carros/{id}
- GET api/carros
- GET api/carros/cor/{cor}
- GET api/carros/marca/{marca}
- GET api/carros/modelo/{modelo}
- GET api/carros/ano/{ano}
- GET api/carros/motorizacao/{motor}


