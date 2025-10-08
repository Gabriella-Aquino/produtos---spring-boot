# API de Produtos – CRUD em Memória (Spring Boot)

Este projeto é uma **API REST** desenvolvida em **Spring Boot**, que realiza operações **CRUD completas** (Create, Read, Update e Delete) sobre uma lista de produtos **mantida em memória**, sem uso de banco de dados.

---

## Tecnologias utilizadas

- Java 17+
- Spring Boot 3
- Spring Web
- Maven

---

## Endpoints

- GET /produtos -- Lista todos
- GET /produtos/{id} -- Busca por ID
- GET /produtos/search?nome={nome} -- Filtra por nome
- POST /produtos -- Adiciona novo
- PUT /produtos/{id} -- Atualiza existente
- DELETE /produtos/{id} -- Remove por ID
- GET /produtos/search?nome=nome_do_item -- filtra por nome.
