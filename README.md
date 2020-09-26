# Desafio Ecommerce

Desafio realizado utilizando a site da amazon para consultar produtos.

# Tecnologias

- Spring Boot
- Hibernate
- JSoup
- PostgreSQL

# Execução

Foi criado uma api REST para consultar os produtos cadastrados.

Foram criados 5 endpoints, são eles:

1- Salva os produtos no banco de dados que são consultados no site da amazon.
### http://localhost:8080/api/salvarProdutos

2- Exibe o produto com maior desconto.
### http://localhost:8080/api/produto/maiorDesconto

3- Exibe o produto melhor avaliado.
### http://localhost:8080/api/produto/melhorAvaliado

4- Exibe o produto tem apresenta o menor preço.
### http://localhost:8080/api/produto/menorPreco

5- Lista SOMENTE os produtos que apresenta respectivamente: Menor preço, mais popular e com maior desconto.
### http://localhost:8080/api/produtos

