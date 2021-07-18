# Avaliação Java

## O que é essa API ?
  Se trata de uma camada de serviço de um carrinho de compras para um ecommerce.
  Calcula o valor do frete e define frete gratis para valores acima de 250,00.
  É possível também ordenar os produtos escolhidos.
  
## Execução e Ferramentas
  Para efetuar a execução do projeto basta executar o comando abaixo na pasta raiz:

    mvn clean install && cd target/ && java -jar game-store-1.0.0-SNAPSHOT.jar

    
## EndPoints
* GET http://localhost:8080/product

  Lista todos os produtos disponíveis com suas características.
```json
[
  {
    "id": 12,
    "name": "Mortal Kombat XL",
    "price": 69.99,
    "score": 150,
    "image": "mortal-kombat-xl.png"
  }
]
```
		

* POST http://localhost:8080/checkout

  Cria o carrinho de compras com os itens inseridos e calcula e informa o valor do frete.


  RequestBody:

        [12, 31, 74]

  Response:
```json
{
    "id": 1,
    "products": [
        {
            "id": 12,
            "name": "Mortal Kombat XL",
            "price": 69.99,
            "score": 150,
            "image": "mortal-kombat-xl.png"
        },
        {
            "id": 31,
            "name": "Terra Média: Sombras de Mordor",
            "price": 79.99,
            "score": 50,
            "image": "terra-media-sombras-de-mordor.png"
        },
        {
            "id": 74,
            "name": "Shards of Darkness",
            "price": 71.94,
            "score": 400,
            "image": "shards-of-darkness.png"
        }
    ],
    "subTotal": 221.92,
    "shipping": 30,
    "total": 251.92
}
```

* PUT http://localhost:8080/checkout/{id}

  Atualiza o carrinho de compras baseado nos Ids passados através do requestBody e calcula e informa o valor do frete.

  RequestBody:
  
        [12, 31]
  
  Response:
```json
{
  "id": 1,
  "products": [
    {
      "id": 12,
      "name": "Mortal Kombat XL",
      "price": 69.99,
      "score": 150,
      "image": "mortal-kombat-xl.png"
    },
    {
      "id": 31,
      "name": "Terra Média: Sombras de Mordor",
      "price": 79.99,
      "score": 50,
      "image": "terra-media-sombras-de-mordor.png"
    }
  ],
  "subTotal": 149.98,
  "shipping": 20,
  "total": 169.98
}
```
	
* GET http://localhost:8080/checkout/{id}?order=name

  Define por ordem alfabética a posição dos itens.

  Response:
```json
{
    "id": 1,
    "products": [
    {
        "id": 12,
        "name": "Mortal Kombat XL",
        "price": 69.99,
        "score": 150,
        "image": "mortal-kombat-xl.png"
    },
    {
        "id": 74,
        "name": "Shards of Darkness",
        "price": 71.94,
        "score": 400,
        "image": "shards-of-darkness.png"
    },
    {
        "id": 31,
        "name": "Terra Média: Sombras de Mordor",
        "price": 79.99,
        "score": 50,
        "image": "terra-media-sombras-de-mordor.png"
    }
    ],
    "subTotal": 221.92,
    "shipping": 30.00,
    "total": 251.92
}
```

* GET http://localhost:8080/checkout/{id}?order=score

  Define por ordem de pontuação a posição dos itens.

  Response:
```json
{
  "id": 1,
  "products": [
    {
      "id": 31,
      "name": "Terra Média: Sombras de Mordor",
      "price": 79.99,
      "score": 50,
      "image": "terra-media-sombras-de-mordor.png"
    },
    {
      "id": 12,
      "name": "Mortal Kombat XL",
      "price": 69.99,
      "score": 150,
      "image": "mortal-kombat-xl.png"
    },
    {
      "id": 74,
      "name": "Shards of Darkness",
      "price": 71.94,
      "score": 400,
      "image": "shards-of-darkness.png"
    }
  ],
  "subTotal": 221.92,
  "shipping": 30.00,
  "total": 251.92
}
```

* GET http://localhost:8080/checkout/{id}?order=price

  Define por ordem de preço a posição dos itens.

  Response:
```json
{
  "id": 1,
  "products": [
    {
      "id": 12,
      "name": "Mortal Kombat XL",
      "price": 69.99,
      "score": 150,
      "image": "mortal-kombat-xl.png"
    },
    {
      "id": 74,
      "name": "Shards of Darkness",
      "price": 71.94,
      "score": 400,
      "image": "shards-of-darkness.png"
    },
    {
      "id": 31,
      "name": "Terra Média: Sombras de Mordor",
      "price": 79.99,
      "score": 50,
      "image": "terra-media-sombras-de-mordor.png"
    }
  ],
  "subTotal": 221.92,
  "shipping": 30.00,
  "total": 251.92
}
```
		
## Frameworks

  Foi utilizado no projeto os frameworks SpringBoot e SpringJPA, utilizei ambos por ser os que tenho familiaridade e pelo SpringBoot auxiliar na utilização dos EndPoints e o JPA auxiliar na comunicação com o banco de dados.
  
