# 🍽️ Sistema de Gerenciamento de Restaurante

### Sobre o Projeto

Esse projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos (POO) do meu curso de ADS. A ideia era criar um sistema simples de restaurante usando Java para praticar os conceitos que o professor passou em aula, como Herança, Classes Abstratas e o uso de Listas.

O sistema simula algumas operações básicas de um restaurante, como anotar pedidos, gerenciar as mesas e fechar a conta.

### Funcionalidades

- Cadastrar comidas e bebidas no cardápio.
- Ver se uma mesa está livre ou ocupada com um pedido.
- Criar um pedido para uma mesa, podendo adicionar ou remover itens.
- Calcular o total da conta de uma mesa.
- Finalizar um pedido e deixar a mesa livre de novo.

### Como eu organizei o projeto

Eu dividi o sistema em algumas classes para cada coisa ter seu lugar:

* **`ItemCardapio`**: Essa é a classe "mãe" de `Comida` e `Bebida`. Como os dois tinham nome, preço e descrição, achei que fazia sentido criar uma classe abstrata pra eles.

* **`Comida` e `Bebida`**: São as classes que herdam de `ItemCardapio`. Cada uma tem um detalhe a mais: `Comida` diz se é um prato vegano e `Bebida` se tem álcool.

* **`Pedido`**: Essa classe guarda os itens que uma mesa pediu. Ela tem uma lista de `ItemCardapio` e métodos para adicionar/remover itens e calcular o total.

* **`Mesa`**: Representa uma mesa do restaurante. Ela pode ter um `Pedido` associado a ela e tem os métodos pra abrir e fechar um pedido.

* **`Restaurante`**: É a classe que junta tudo e faz o sistema funcionar. Ela tem a lista com todas as mesas e o cardápio completo, e é por ela que a gente registra um pedido ou gera uma conta.

* **`Main`**: Criei essa classe só pra testar e mostrar que tudo está funcionando como deveria, com um exemplo de cada funcionalidade.

### Tecnologias

* Java

### Como executar o projeto

Pra rodar o projeto no seu computador:

1.  Coloque todos os arquivos `.java` na mesma pasta.
2.  Abra o terminal nessa pasta.
3.  Compile os arquivos com o comando:
    ```bash
    javac *.java
    ```
4.  Depois de compilar, rode o programa com o comando:
    ```bash
    java Main
    ```

---

### Autor

* **Aluno:** Saulo Torres
* **Curso:** Análise e Desenvolvimento de Sistemas (ADS)
* **Disciplina:** Programação Orientada a Objetos (POO)
* **Professor:** Rafael Marinho dos Anjos
