// Aluno: Saulo Torres
// Disciplina: Programação Orientada a Objetos (POO)

// Esta é a classe que representa uma mesa no restaurante.
public class Mesa {
    
    // Aqui são os atributos da mesa
    private int numero;
    private Pedido pedidoAtual;

    // O construtor da mesa
    public Mesa(int numero) {
        this.numero = numero;
        this.pedidoAtual = null; // A mesa começa sem nenhum pedido
    }
    
    // Aqui estão os métodos para pegar os dados da mesa
    public int getNumero() { return numero; }
    public Pedido getPedidoAtual() { return pedidoAtual; }

    // Este método abre um novo pedido para a mesa
    public void abrirPedido() {
        if (this.pedidoAtual == null || this.pedidoAtual.isFinalizado()) {
            this.pedidoAtual = new Pedido(this);
        }
    }

    // E este fecha o pedido que está aberto
    public void fecharPedido() {
        if (this.pedidoAtual != null && !this.pedidoAtual.isFinalizado()) {
            this.pedidoAtual.finalizarPedido();
        }
    }

    // Esse toString é pra mostrar o status da mesa de forma clara
    @Override
    public String toString() {
        String status = " (Livre)";
        if (pedidoAtual != null && !pedidoAtual.isFinalizado()) {
            status = " (Ocupada com pedido aberto)";
        }
        return "Mesa " + numero + status;
    }
}