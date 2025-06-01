// Aluno: Saulo Torres
// Disciplina: Programação Orientada a Objetos (POO)

// Essa daqui é a classe abstrata, o modelo para Comida e Bebida.
public abstract class ItemCardapio {
    
    // Aqui são os atributos que todo item vai ter
    protected String nome;
    protected double preco;
    protected String descricao;

    // O construtor da classe, para criar um item novo
    public ItemCardapio(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    // São os métodos para pegar os dados do item
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public String getDescricao() { return descricao; }

    // Um método abstrato obriga as classes filhas a dizerem que tipo de item são.
    public abstract String getTipo();

    // Aqui sobrescrevi o toString pra mostrar o item de um jeito bonito
    @Override
    public String toString() {
        return "Nome: " + nome + " (R$ " + String.format("%.2f", preco) + ") - Descricao: " + descricao;
    }
}