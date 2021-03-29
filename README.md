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

1. Clonar projeto 'fizz-buzz'
	`git clone https://github.com/andrebrandaodf/fizz-buzz.git`
	
2. Entrar na pasta do projeto `fizz-buzz` 

	`cd fizz-buzz`
 
3. Executar o servidor spring 

	`mvn spring-boot:run`

# Consumindo API REST

**Inserindo Usuario via POSTMAN**

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

GET http://localhost:8080/usuarios?email=andrebrandaodf@gmail.com Pesquisar por email

GET http://localhost:8080/usuarios?numero=5 Pesquisar por numero

GET http://localhost:8080/usuarios?resultado=Buzz Pesquisar por resultado
