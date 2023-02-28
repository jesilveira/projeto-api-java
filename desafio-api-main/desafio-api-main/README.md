## Desafio API - GFT Start Woman 2022


## Sobre o Projeto

O projeto desenvolvido é uma API Rest para Controle e Produção de vendas de uma Indústria Automobilística. A ferramenta permite criar, editar, visualizar e excluir os seus produtos. Requer uma autenticação para acesso.

Elementos disponíveis para uso, sendo eles livremente configuráveis pelo administrador:
- Fornecedor: CNPJ, nome, telefone, email, endereço.
- Peça: descrição, categoria, fornecedor, marca, tempo de entrega, qualidade, valor da unidade, valor total da peça em estoque e quantidade. 
- Estoque: exibe peças em estoque, exibe veículos, exibe peças por categoria e fornecedor, exibe o valor total em estoque de cada categoria e exibe valor total do estoque. 
- Veículo: marca, descrição, custo do produto, valor de venda e tempo de entrega.
- Categoria: descrição, categoria, fornecedor, marca, tempo de entrega, qualidade, valor da unidade, quantidade e valor total.

## Como utilizar
- Após criar o banco de dados o administrador deverá inserir no campo "nome" da tabela "roles" a palavra "usuario", para permitir o cadastro de usuários.
- Como as páginas possuem acesso bloqueado ao público, o administrador deve primeiramente se cadastrar através da página de cadastro e em seguida realizar o seu login. A partir daí, a navegação pelas ferramentas são liberadas para uso.
- Para realizar o cadastro de itens o administrador deverá iniciar com a criação da categoria, em seguida o fornecedor e por fim as peças ou veículo.
PS: No arquivo application.properties, coloque seu usuário e senha do banco de dados para que a aplicação possa se conectar.

## Tecnologias Utilizadas

**IDE: Spring Tool Suite**

**Versão do Java: Java 17**
- SPRING 2.7.5
- MAVEN
- DEVTOOLS
- MYSQL DRIVER
- SPRING WEB
- JPA
- VALIDATION
- SPRING SECURITY
- JSON WEB TOKEN

## Grupo 7
### Desenvolvedoras
- Alice Gabriela Silva Alves
- Ana Beatriz Miranda Gadelha
- Caroline de Souza Dainezi
- Jéssika Santos dos Santos Silveira
