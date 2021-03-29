# Desafio Fizz Buzz - Find Soluções!

* Java 11
* [Spring Boot 2.4.4.RELEASE](https://start.spring.io/)
* Mysql Driver
* [IDE SpringTools](https://spring.io/tools)
* Lombok
* Spring Web
* Spring Data JPA
* Maven 4.0.0

# Executando projeto

1. Entrar na pasta do projeto `fizz-buzz` 

	`cd fizz-buzz`
 
2. Executar o servidor spring 

	`./mvnw spring-boot:run`

# Métodos CRUD Usuario

**Inserindo Usuario**

POST http://localhost:8080/usuarios 

```
{
            "email": "andrebrandaodf@gmail.com",
            "numero": 5
}
```

**Filtrar histórico do Usuario por data, e-mail do usuário, número pesquisado e/ou resultado obtido via url**

GET http://localhost:8080/usuarios Lista todos os usuários
    
GET http://localhost:8080/usuarios?date=2021-03-29 Pesquisar por data

GET http://localhost:8080/usuarios?numero=5 Pesquisar por numero

GET http://localhost:8080/usuarios?resultado=Buzz Pesquisar por resultado
