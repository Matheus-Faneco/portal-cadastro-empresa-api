## Portal de serviço ST [Cadastro de Empresa] (Backend)

API REST desenvolvida em Java com SpringBoot para o Portal ST de Cadastro de Empresas.

Tecnologias que foram utilizadas
* Java 21
* Spring Boot 4.0.3
* Spring Data JPA
* PostgreSQL 
* Lombok
* Maven

O Banco de dados utilizado foi o PostgreSQL.

---
## Estrutura do Projeto



Em `EmpresaController` se encontram os endpoints de cadastrar, aprovar, reprovar e listar empresas,
tanto o listamento de todas quanto apenas as pendentes. Em `DocumentoController` está o endpoint
de upload do documento, aceitando apenas formatos válidos (pdf, png, jpg e jpeg).
Os documentos enviados estão sendo armazenados na pasta `uploads/` na raiz do projeto.


Em `model` há os enums para melhor organização. 
* `Perfil` (tipos de perfil da empresa),
* `StatusCadastro` (PENDENTE, APROVADO, REPROVADO) e`TipoPessoa` (JURIDICA, FISICA, ESTRANGEIRA).
* A classe `Empresa` está abrangindo todos esses enums.

`EmpresaRepository` é a camada onde está encapsulada a lógica de interação com o banco de dados.

Em `EmpresaService` estão as regras de negócio [RN01] e [RN02]. Cadastros realizados
por usuário interno são aprovados automaticamente, enquanto cadastros por usuário externo
aguardam aprovação com status PENDENTE.

