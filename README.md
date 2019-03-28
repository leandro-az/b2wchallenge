# **API REST STAR WARS – B2W**

Esse repositório refere-se ao desafio de implementação back-end proposto pela b2w

## Tecnologias Utilizadas:

* Linguagem de Programação JAVA
* Spring Boot
* Spring MVC
* Mongodb Cloud
* Heroku
* JUnit
* Rest-assured
* Swagger

# Descrição do Projeto:
A aplicação foi desenvolvida utilizando a linguagem JAVA, codificada utilizando a IDE eclipse e com acesso a um bando de dados externo armazenado na nuvem ( MongoDb cloud). 
A ideia deste projeto é de cria uma aplicação REST que armazene e retorne informações referentes aos planetas que aparecem ou são citados pela maravilhosa franquia Star Wars. 

# Testes:

Desenvolvi uma classe Teste (B2wchallengeApplicationTests) com auxílio da dependência rest-assured, com o objetivo de validar as funcionalidades desenvolvidas: 

* Adicionar um planeta 
* Atualizar informações de um planeta 
* Buscar Planeta pelo Nome 
* Buscar Planeta pelo ID 
* Deletar um planeta.

# Utilização das funcionalidades solicitadas:

Dentre as muitas maneiras de se apresentar e utilizar a aplicação.Uma delas sendo:

Baixar projeto >> Compilar >> testar a API REST utilizando alguma ferramenta externa como POSTMAN.

Optei por disponibilizar a aplicação em um ambiente de deploy de aplicação freeware, acessível de diversas plataformas. Graças ao Swagger também foi possível documentar bem a aplicação MVC e disponibilizar uma área de testes facilitada, como pode-se verificar na opção " planet-controller " acessado através do link:

https://newbchallenge.herokuapp.com/swagger-ui.html


Ainda que o link acima facilite a validação. A aplicação pode ser testada da seguinte forma através dos endpoints:

PUT: https://newbchallenge.herokuapp.com/api/planet  **>>** Cria um novo planeta.
```
Parâmetros (Body)

Planet {
climate (string, optional),
id (string, optional),
name (string, optional),
qtd_apparitions (integer, optional),
terrain (string, optional)
}
```
POST: https://newbchallenge.herokuapp.com/api/planet/{id}  **>>** Atualiza um planeta.
```
Parâmetros (Query String)
string: id (required)
```
Parâmetros (Body)
```
Planet {
climate (string, optional),
id (string, optional),
name (string, optional),
qtd_apparitions (integer, optional),
terrain (string, optional)
}
```
GET: https://newbchallenge.herokuapp.com/api/planet  **>>** Recupera a lista de planetas;

GET:  https://newbchallenge.herokuapp.com/api/planet/{id} **>>** Recupera o planeta pelo ID;
```
Parâmetros (Query String)
string: id (required)
```

GET:  https://newbchallenge.herokuapp.com/api/planetn/{name} **>>** Recupera Planeta Pelo Nome;

```
Parâmetros (Query String)
string: name (required)

```

DELETE:  https://newbchallenge.herokuapp.com/api/planet/{id} **>>** Remove o planeta com o ID especificado.
```
Parâmetros (Query String)
string: name (required)

```

# Considerações Finais:

Espero ter sido claro e que tenha atendido em grande parte o que foi solicitado. Agraço a participação e  **“May the Force be with you”.**
