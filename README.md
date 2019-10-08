# Pigmento-POO
Sistema de Venda de Tintas

Projeto para fins didáticos da matéria de Programação Orientada a Objetos

1. Antes de rodar a apicação certifique-se de ter o PostgreSQL instalado na máquina
    1. Crie um Banco de Dados chamado: Pigmento
    2. Rode o arquivo script.sql deixado dentro da pasta de arquivo-apoio para criar a tabela e inserções de teste no banco
    3. Certifique-se de trocar a senha de conexão do postgre no arquivo de AbstractConexionSQLDAO.java

2. Dentro do projeto, configure o caminho do Driver JDBC. 
    1. Clicar com o botão direito no nome do projeto (pigmento)
    2. Properties
    3. Java Build Path
    4. Clica no arquivo do postgresql-42.2.8.jar
    5. Edit...
    6. Por fim redireciona corretamente para o arquivo que está na pasta driver
3. Após isso escolha uma das classes de interface de usuário para rodar a aplicação
    1. ConsoleView ou PigmentoView.
