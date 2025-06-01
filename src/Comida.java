// Aluno: Saulo Torres
// Disciplina: Programação Orientada a Objetos (POO)

// Aqui é a classe Comida, que é um tipo de ItemCardapio
public class Comida extends ItemCardapio {
    
    // É o atributo extra que só a comida tem
    private boolean ehVegano;

    // Um construtor para criar um prato de comida
    public Comida(String nome, double preco, String descricao, boolean ehVegano) {
        super(nome, preco, descricao);
        this.ehVegano = ehVegano;
    }

    // O método pra saber se é vegano ou não
    public boolean isEhVegano() {
        return ehVegano;
    }

    // Aqui eu sou obrigado a dizer que o tipo é "Comida"
    @Override
    public String getTipo() {
        return "Comida";
    }

    // Mudei o toString pra adicionar a informação se é vegano
    @Override
    public String toString() {
        return super.toString() + " - Vegano: " + (ehVegano ? "Sim" : "Nao") + " [" + getTipo() + "]";
    }
}