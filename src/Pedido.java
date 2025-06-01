// Aluno: Saulo Torres
// Disciplina: Programação Orientada a Objetos (POO)

import java.util.ArrayList;
import java.util.List;

// Aqui nessa classe é a que representa o pedido de uma mesa. Não fala com o usuário, só guarda os dados.
public class Pedido {
    
    private List<ItemCardapio> itens;
    private Mesa mesa;
    private boolean finalizado;

    // O construtor do pedido
    public Pedido(Mesa mesa) {
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.finalizado = false;
    }

    // São os getters para pegar os atributos
    public List<ItemCardapio> getItens() { return itens; }
    public Mesa getMesa() { return mesa; }
    public boolean isFinalizado() { return finalizado; }

    // Aqui é o método para colocar um item na lista do pedido
    public void adicionarItem(ItemCardapio item) {
        if (!finalizado) {
            this.itens.add(item);
        }
    }

    // Aqui já é o método para tirar um item do pedido pelo nome, retorna true se conseguiu
    public boolean removerItem(String nomeDoItem) {
        if (!finalizado) {
            for (int i = 0; i < itens.size(); i++) {
                if (itens.get(i).getNome().equals(nomeDoItem)) {
                    itens.remove(i);
                    return true; // Encontrou e removeu
                }
            }
        }
        return false; // Não encontrou ou pedido finalizado
    }

    // E esse calcula o valor total do pedido somando o preço de cada item
    public double calcularTotal() {
        double total = 0;
        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    // Já esse método marca o pedido como finalizado
    public void finalizarPedido() {
        this.finalizado = true;
    }
}