# Quarkus Panache REST - Projeto completo

## Conteúdo
Projeto Quarkus com Panache ORM, H2 (in-memory) e endpoints REST (CRUD) para as entidades:
- Categoria
- Fabricante
- Produto
- Funcionario
- Cliente
- Venda
- ItemVenda

## Requisitos
- Java 17
- Maven

## Como rodar
```bash
mvn clean package
mvn quarkus:dev
```
A API ficará disponível em http://localhost:8080


## Endpoints (exemplos)
- GET /categorias
- POST /categorias
- GET /categorias/{id}
- PUT /categorias/{id}
- DELETE /categorias/{id}

Mesma estrutura para:
- /fabricantes
- /produtos
- /funcionarios
- /clientes
- /vendas
- /itensvenda

## Importar coleção Postman
O arquivo `postman_collection.json` está incluso. Importe no Postman.

## Subir no GitHub
```bash
git init
git add .
git commit -m "Initial commit - Quarkus Panache REST"
# criar repo no GitHub e adicionar origin, então:
git branch -M main
git remote add origin https://github.com/SEU_USUARIO/quarkus-panache-rest.git
git push -u origin main
```
