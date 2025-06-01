// Aluno: Saulo Torres
// Disciplina: Programação Orientada a Objetos (POO)

import java.util.ArrayList;
import java.util.List;

// Essa é a classe que controla tudo e conversa com o usuário.
public class Restaurante {
    
    private List<ItemCardapio> cardapio;
    private List<Mesa> mesas;

    // Esse construtor do restaurante, inicializa as listas vazias
    public Restaurante() {
        this.cardapio = new ArrayList<>();
        this.mesas = new ArrayList<>();
    }

    // Ele adiciona um item no cardápio geral do restaurante
    public void adicionarItemCardapio(ItemCardapio item) {
        this.cardapio.add(item);
    }

    // Então mostra todos os itens do cardápio na tela
    public void listarCardapio() {
        System.out.println("\n--- Cardapio do Restaurante ---");
        for (ItemCardapio item : cardapio) {
            System.out.println(item.toString());
        }
        System.out.println("-----------------------------");
    }
    
    // Aqui adiciona uma nova mesa no restaurante
    public void adicionarMesa(Mesa mesa) {
        this.mesas.add(mesa);
    }

    // Um método privado só para ajudar a encontrar uma mesa pelo número
    private Mesa buscarMesa(int numeroMesa) {
        for (Mesa mesa : this.mesas) {
            if (mesa.getNumero() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }
    
    // Outro método privado para checar se um item existe no cardápio pelo nome
    private boolean itemExisteNoCardapio(String nomeDoItem) {
        for (ItemCardapio item : this.cardapio) {
            if (item.getNome().equals(nomeDoItem)) {
                return true;
            }
        }
        return false;
    }

    // Esse registra um pedido para uma mesa específica
    public void registrarPedido(int numeroMesa, List<ItemCardapio> itens) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa == null) {
            System.out.println("Erro: Mesa " + numeroMesa + " nao encontrada.");
            return;
        }

        if (mesa.getPedidoAtual() == null || mesa.getPedidoAtual().isFinalizado()) {
            mesa.abrirPedido();
            System.out.println("Novo pedido aberto para a mesa " + numeroMesa + ".");
        }

        Pedido pedido = mesa.getPedidoAtual();
        for (ItemCardapio item : itens) {
            // Aqui verifica se o item pedido realmente existe no cardápio antes de adicionar
            if (itemExisteNoCardapio(item.getNome())) {
                pedido.adicionarItem(item);
                System.out.println("Item '" + item.getNome() + "' adicionado ao pedido da mesa " + numeroMesa + ".");
            } else {
                System.out.println("Item '" + item.getNome() + "' nao existe no cardapio e nao foi adicionado.");
            }
        }
    }

    // Este gera a conta da mesa e finaliza o pedido
    public void gerarConta(int numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa == null) {
            System.out.println("Erro: Mesa " + numeroMesa + " nao encontrada.");
            return;
        }

        Pedido pedido = mesa.getPedidoAtual();
        if (pedido == null || pedido.getItens().isEmpty()) {
            System.out.println("Nao ha pedido ativo na mesa " + numeroMesa + " para gerar conta.");
            return;
        }

        System.out.println("\n--- Conta da Mesa " + numeroMesa + " ---");
        for (ItemCardapio item : pedido.getItens()) {
            System.out.println("- " + item.getNome() + " (R$ " + String.format("%.2f", item.getPreco()) + ")");
        }
        System.out.println("-------------------------");
        System.out.println("Total: R$ " + String.format("%.2f", pedido.calcularTotal()));
        System.out.println("-------------------------");

        mesa.fecharPedido();
        System.out.println("Pedido da mesa " + numeroMesa + " finalizado. Mesa esta livre.");
    }
    
    // Esse lista todas as mesas e o status delas (livre/ocupada)
    public void listarMesas() {
        System.out.println("\n--- Status Atual das Mesas ---");
        for (Mesa m : mesas) {
            System.out.println(m.toString());
        }
        System.out.println("----------------------------");
    }
}