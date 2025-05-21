# API Sistemas Distribuídos - *Por: Gabriel Coutinho*
**Esta API gerencia 2 tipos de entidades, Funcionário e Tarefas, onde em uma será possível cadastrar seus funcionários e atribuir seus cargos, e em tarefas serão alocadas funções a esses funcionários.**

# Requisitos
* **Há 3 tipos diferentes de clientes: o funcionário, o supervisor e o gerente;**

* **O funcionário acompanha as tarefas alocadas para ele informa sempre que uma dessas tarefas foi concluída;**

* **O supervisor cadastra tarefas para os funcionários e acompanha a execução das mesmas;**

* **O gerente emite relatórios em tempo real sobre o andamento do trabalho na empresa;**

* **Os dados devem ser armazenados em um banco de dados relacional (MySQL, SQLite, etc);**

* **Este serviço deve ser RESTFul.**

# Métodos http
* API - Funcionário
  
*POST*
**http://localhost:8080/api/funcionario -> Cadastra um novo funcionario**

*GET*
**http://localhost:8080/api/funcionario -> Lista todos os funcionarios cadastrados**

*GET*
**http://localhost:8080/api/funcionario/id/{id} -> Retorna um funcionario pelo id**

*GET*
**http://localhost:8080/api/funcionario/cargo/{CARGO} -> Retorna uma lista funcionarios pelo cargo atribuído**

*GET*
**http://localhost:8080/api/funcionario/nome/{nome} -> Retorna um funcionario pelo nome**

*PATCH*
**http://localhost:8080/api/funcionario/update/{id} -> Altera o cargo de um funcionario pelo id**

*DELETE*
**http://localhost:8080/api/funcionario/delete/{id} -> Deleta cadastro do funcionario através do id**

****

* API - Tarefa

*POST*
**http://localhost:8080/api/tarefa -> Cria uma nova tarefa**

*GET*
**http://localhost:8080/api/tarefa -> Lista todas as tarefas**

*GET*
**http://localhost:8080/api/tarefa/uid/{uid} -> Busca tarefas pelo uid**

*GET*
**http://localhost:8080/api/tarefa/status/{STATUS} -> Retorna uma lista de tarefas através do status atribuído**

*GET*
**http://localhost:8080/api/tarefa/supervisor/{supervisor} -> Retorna uma tarefa pelo nome do supervisor**

*GET*
**http://localhost:8080/api/tarefa/atendente/{atendente} -> Retorna uma tarefa pelo nome do atendente**

*PATCH*
**http://localhost:8080/api/tarefa/update/{uid} -> Altera o status de uma tarefa pela busca do uid**

*DELETE*
**http://localhost:8080/api/tarefa/delete/{uid} -> Deleta uma tarefa através do uid**
  
# Plataformas utilizadas
* Linguagem de programação -> JAVA
* Framework -> SpringBoot
* IDE -> Intellij
* Banco de Dados -> PostgreSQL
* Ambiente para versionamento de código -> Git e GitHub
* Ambiente para Contêinerização -> Docker

# URL para documentação da API
http://localhost:8080/sistemas-docs.html

# Documento de configuração do ambiente para rodar a API
[A3 - Sistemas - Configuração de ambiente.pdf](https://github.com/user-attachments/files/20358339/A3.-.Sistemas.-.Configuracao.de.ambiente.pdf)







