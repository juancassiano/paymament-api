# Getting Started


# Payment API

O bjetivo é criar uma API para possibilitar o recebimento de pagamentos de débitos de pessoas físicas e jurídicas.

Quando a API receber um pagamento, este deverá ser armazenado no banco de dados com status Pendente de Processamento. Uma aplicação terceira (não se preocupe com ela) irá processar o pagamento e efetuar uma chamada para sua API, solicitando a alteração do status do pagamento de Pendente para Processado.

Sua API também deve listar todos os pagamentos recebidos e oferecer para o cliente a possibilidade de filtrar os pagamentos.

## Requisitos

- A API deve ser capaz de receber um pagamento.

- Um pagamento possui os seguintes campos:

- Código do Débito sendo pago (valor inteiro)

- CPF ou CNPJ do Pagador

- Método de pagamento (boleto, pix, cartao_credito ou cartao_debito)

- Número do cartão: Este campo só será enviado se o método de pagamento for cartao_credito ou cartao_debito.

- Valor do pagamento

- A API deve ser capaz de atualizar o status de um pagamento.

- A atualização do status de um pagamento sempre irá conter o ID do Pagamento e o novo status.

- Quando o pagamento está Pendente de Processamento, ele pode ser alterado para Processado com Sucesso ou Processado com Falha.

- Quando o pagamento está Processado com Sucesso, ele não pode ter seu status alterado.

- Quando o pagamento está Processado com Falha, ele só pode ter seu status alterado para Pendente de Processamento.

- A API deve ser capaz de listar todos os pagamentos recebidos e oferecer filtros de busca para o cliente.

- Os filtros de busca devem ser:

- Por código do débito

- Por CPF/CNPJ do pagador

- Por status do pagamento

- A API deve ser capaz de deletar um pagamento, desde que este ainda esteja com status Pendente de Processamento.
### Documentação de Referência

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#io.validation)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#web)

### Guias

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


## Documentação

[Swagger](http://localhost:8080/swagger-ui/index.html#/)

