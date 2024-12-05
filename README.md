AV3POO - Projeto de Avaliação
📖 Descrição
Este projeto é parte da avaliação da disciplina AV3POO, desenvolvido com o objetivo de aplicar os conceitos de Programação Orientada a Objetos (POO) usando o framework Spring Boot. A aplicação integra com os bancos de dados PostgreSQL (para produção) e MySQL (para testes), e inclui validações e testes automatizados, garantindo a qualidade e a robustez do código.

⚙️ Tecnologias e Dependências
Spring Boot 3.3.4: Framework principal para o desenvolvimento da aplicação.
Java 17: Versão do Java utilizada para o desenvolvimento.
Spring Boot Starter Data JPA: Integração com bancos de dados e manipulação de dados.
Spring Boot Starter Validation: Validação de entradas de dados para garantir a consistência e segurança.
Spring Boot Starter Web: Para construção de APIs RESTful.
Spring Boot DevTools: Ferramentas para otimizar o desenvolvimento e facilitar o ciclo de vida da aplicação.
PostgreSQL: Banco de dados utilizado em produção.
MySQL: Banco de dados para testes.
H2 Database: Banco de dados em memória, ideal para testes rápidos e locais.
Lombok: Biblioteca para reduzir a verbosidade do código, facilitando a utilização de anotações.
Spring Boot Starter Test: Framework para automação de testes, garantindo a qualidade do sistema.
Apache Commons Lang3: Utilitário para manipulação de strings e operações comuns.
🖥️ Como Rodar o Projeto
Clone o repositório:
bash
Copiar código
git clone https://github.com/seu-usuario/av3poo.git
Abra o projeto em sua IDE preferida (Ex: IntelliJ IDEA, Eclipse).

Configure o banco de dados:

Para produção, configure o PostgreSQL.
Para testes, configure o MySQL.
Execute o projeto:

Abra o terminal e execute o comando:
bash
Copiar código
./mvnw spring-boot:run
Acesse a API:
Após o projeto ser iniciado, a aplicação estará disponível em http://localhost:8080.
🛠️ Funcionalidades Implementadas
Criação de APIs RESTful para CRUD de entidades.
Validações para garantir a integridade dos dados.
Testes automatizados para garantir que a aplicação funcione corretamente.
📦 Como Contribuir
Faça um fork deste repositório.
Crie uma branch para a sua alteração (git checkout -b feature/nova-funcionalidade).
Faça as alterações necessárias e commit as mudanças (git commit -am 'Adicionando nova funcionalidade').
Push para a branch (git push origin feature/nova-funcionalidade).
Abra um pull request explicando suas mudanças.
