#API E-COMMERCE JOGOS MOBILE

#Documentação Swagger da API E-commerce
https://e-commerce-gabriel.herokuapp.com/swagger-ui/#
____________________________________________________________________
#Uso de token para acessar os endopints da API(adicionar carrinho,atualizar, deletar produto do carrinho e fazer checkout)
Todos os endopoints da API do carrinho necessita passar um token por parâmetro, que vai ser o HTTP Header. Nesse caso, o token vai funcionar como um identificador para fazer requisição.
O HTTP Header vai ser único cada vez que o usuário acessar a API. Com isso, cada carrinho criado vai ficar registrado com esse token, podendo apenas ser alterado pelo usuário que tiver o mesmo identificador(token),tanto para acessar o carrinho ou fazer checkout.

#Testes de integração e unitário com JUnit

No projeto existem 3 classes de testes (2 de integração e 1 de teste unitário).

Nas classes com teste de integração com a aplicação, são testados a listagem de produtos (ex: ordenação de listagem por preço,score,alfabética) e as operações que envolvem a parte do carrinho (ex: inserção de produtos no carrinho e cálculo de preço/frete).

Na classe de teste unitário, tem um exemplo de teste de cálculo de valor total (subtotal + valor do frete).

#Endpoints para acessar API
(PRODUTOS)
https://e-commerce-gabriel.herokuapp.com/produto/ (Lista os produtos da loja) --- GET
https://e-commerce-gabriel.herokuapp.com/produto/order{ordem} (Lista produtos da loja por ordem (preco,score ou alfabetica)) ---POST

(CARRINHO)
https://e-commerce-gabriel.herokuapp.com/carrinho (Busca carrinho com o token identificador) ---GET

https://e-commerce-gabriel.herokuapp.com/carrinho/{idProduto}/{quantity} (Adiciona item ou altera o carrinho, passando o id do produto,a quantidade a ser adicionada/alterada e o token identificador) ---PUT

https://e-commerce-gabriel.herokuapp.com/carrinho/{idProduto} (Deleta o produto do carrinho, passando o id produto e o token identificador) -- DELETE

https://e-commerce-gabriel.herokuapp.com/carrinho/checkout (Faz o checkout do carrinho, passando o token identificador como parâmetro. A API retorna um response do checkout que contém o valor subtotal, frete( se tiver) e o valor total do carrinho.) --POST

