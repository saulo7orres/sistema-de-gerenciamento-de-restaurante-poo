// Aluno: Saulo Torres
// Disciplina: Programação Orientada a Objetos (POO)

// Essa é a classe Bebida, que também herda de ItemCardapio
public class Bebida extends ItemCardapio {
    
    // É o atributo específico da bebida
    private boolean possuiAlcool;

    // Um construtor para criar uma nova bebida
    public Bebida(String nome, double preco, String descricao, boolean possuiAlcool) {
        super(nome, preco, descricao);
        this.possuiAlcool = possuiAlcool;
    }

    // Aqui é o método para checar se tem álcool
    public boolean isPossuiAlcool() {
        return possuiAlcool;
    }

    // Essa é uma implementação obrigatória do método getTipo
    @Override
    public String getTipo() {
        return "Bebida";
    }

    // E aqui o toString pra mostrar se é alcoólica
    @Override
    public String toString() {
        return super.toString() + " - Alcoolica: " + (possuiAlcool ? "Sim" : "Nao") + " [" + getTipo() + "]";
    }
}