# Avaliação Java

## O que é essa API ?
  Se trata de uma camada de serviço de um carrinho de compras para um ecommerce.
  Calcula o valor do frete e define frete gratis para valores acima de 250,00.
  É possível também ordenar os produtos escolhidos.
  
## Execução e Ferramentas
  O projeto foi feito pela IDE IntelliJ, onde a execução e compilação do projeto é feita.
  Para visualização das EndPoints criadas, foi utilizado o Postman, utilizando os métodos de Get, Post e Put.
  
 Para executar o projeto, é preciso clicar em "Run" no IntelliJ, e então, após o código rodar, inserir os EndPoints abaixo no Postman com seus devidos métodos. (se necessário, atualize o Maven no IntelliJ)
  
## EndPoints
* http://localhost:8080/product

  Lista todos os produtos disponíveis com suas características.
  		
		{
			"id": 12,
			"name": "Mortal Kombat XL",
			"price": 69.99,
			"score": 150,
			"image": "mortal-kombat-xl.png"
		}
		

* http://localhost:8080/checkout/{id}

  Cria e atualiza o carrinho de compras com os itens inseridos e calcula e informa o valor do frete.
  
  	
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
		    "shipping": 30.00,
		    "total": 251.92
		}
	
* http://localhost:8080/checkout/{id}?order=name

  Define por ordem alfabética a posição dos itens.
  
  	
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
		
		
## Frameworks

  Foi utilizado no projeto os frameworks SpringBoot e SpringJPA, utilizei ambos por ser os que tenho familiaridade e pelo SpringBoot auxiliar na utilização dos EndPoints e o JPA auxiliar na comunicação com o banco de dados.
  
# Desafio


## Descrição

  O teste consiste em construir a camada de serviço de um pseudo ecommerce de games mobile utilizando Java

## Como executar os testes
  
  O projeto usa o maven wrapper (mvnw).
  Para executar os testes de exemplo basta o comando abaixo:
  ```sh
  ./mvnw clean test
  ```

## Requisitos

  - Existe um exemplo de carga de banco de dados em memória em [ProductDaoExampleTest.java](./src/test/java/br/com/supera/game/store/ProductDaoExampleTest.java)
  - Os valores exibidos no checkout (frete, subtotal e total) devem ser calculados dinamicamente
  - O usuário poderá adicionar e remover produtos do carrinho
  - O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.
  - A cada produto adicionado, deve-se somar R$ 10,00 ao frete.
  - Quando o valor dos produtos adicionados ao carrinho for igual ou superior a R$ 250,00, o frete é grátis.

## O que iremos avaliar

Levaremos em conta os seguintes critérios:

  - Cumprimento dos requisitos
  - Qualidade do projeto de API e fluidez da DX
  - Organização do código e boas práticas
  - Domínio das linguagens, bibliotecas e ferramentas utilizadas
  - Organização dos commits
  - Escrita e cobertura de testes

## Sobre a entrega

  - A API pode ser HTTP, Restful, WSDL/SOAP, HATEOAS ou gRCP mas deverá ser documentado no [README.md](./README.md) como executar/compilar/empacotar o projeto e quais os endpoints solicitados nos requisitos acima. 
  - A versão do Java pode ser atualizada para 11 ou 14.
  - Não existe restrição de framework (EE, Spring, Quarkus etc) mas será melhor avaliado se justificado no [README.md](./README.md) os motivos da decisão.
