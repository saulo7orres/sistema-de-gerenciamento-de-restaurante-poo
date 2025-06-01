// Aluno: Saulo Torres
// Disciplina: Programação Orientada a Objetos (POO)

import java.util.ArrayList;
import java.util.List;

// Essa daqui é a conhecida classe Main feita para testar tudo.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Sistema de Restaurante, feito por Saulo Torres ===");

        // 1. Criei a instância do restaurante.
        Restaurante meuRestaurante = new Restaurante();

        // 2. Criei os itens do cardápio, 2 comidas e 2 bebidas.
        Comida prato1 = new Comida("Feijoada", 45.50, "Tradicional feijoada brasileira", false);
        Comida prato2 = new Comida("Moqueca Vegana", 52.00, "Moqueca de banana da terra", true);
        Bebida bebida1 = new Bebida("Suco de Laranja", 8.00, "Natural, 500ml", false);
        Bebida bebida2 = new Bebida("Cerveja IPA", 18.00, "Artesanal, 350ml", true);

        // 3. Adicionei os itens criados no cardápio do restaurante.
        meuRestaurante.adicionarItemCardapio(prato1);
        meuRestaurante.adicionarItemCardapio(prato2);
        meuRestaurante.adicionarItemCardapio(bebida1);
        meuRestaurante.adicionarItemCardapio(bebida2);

        // 4. Mandei listar o cardápio pra ver se funcionou.
        meuRestaurante.listarCardapio();

        // 5. Criei as mesas e adicionei no restaurante.
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        meuRestaurante.adicionarMesa(mesa1);
        meuRestaurante.adicionarMesa(mesa2);
        meuRestaurante.adicionarMesa(mesa3);

        // 6. Listei as mesas para ver o status inicial de cada uma.
        meuRestaurante.listarMesas();
        
        // 7. Fiz um pedido para a mesa 1 com alguns itens.
        System.out.println("\n--- Fazendo pedido para Mesa 1 ---");
        List<ItemCardapio> pedidoParaMesa1 = new ArrayList<>();
        pedidoParaMesa1.add(prato1);
        pedidoParaMesa1.add(bebida2); 
        pedidoParaMesa1.add(bebida2); 
        meuRestaurante.registrarPedido(1, pedidoParaMesa1);
        
        // 8. Testei remover um item do pedido da mesa 1.
        System.out.println("\n--- Removendo um item do pedido da Mesa 1 ---");
        Pedido pedidoM1 = mesa1.getPedidoAtual();
        if (pedidoM1 != null) {
            // Removendo o item pelo nome, como uma string
            boolean removido = pedidoM1.removerItem("Cerveja IPA"); 
            if(removido) {
                System.out.println("Item 'Cerveja IPA' foi removido com sucesso.");
            }
        }
        
        // 9. Criei um segundo pedido, agora para a mesa 2.
        System.out.println("\n--- Fazendo pedido para Mesa 2 ---");
        List<ItemCardapio> pedidoParaMesa2 = new ArrayList<>();
        pedidoParaMesa2.add(prato2);
        pedidoParaMesa2.add(bebida1);
        meuRestaurante.registrarPedido(2, pedidoParaMesa2);
        
        // 10. Testei a função de gerar a conta da mesa 1.
        meuRestaurante.gerarConta(1);

        // 11. Verifiquei se o status da mesa 1 mudou para "Livre".
        System.out.println("\n--- Verificando status geral apos fechar a conta 1 ---");
        meuRestaurante.listarMesas();
        
        // 12. Tentei adicionar um item num pedido que já foi finalizado.
        System.out.println("\n--- Testando adicionar item em pedido finalizado (Mesa 1) ---");
        if(pedidoM1.isFinalizado()){
            System.out.println("Pedido da Mesa 1 está finalizado. Tentativa de adicionar item deve falhar.");
            pedidoM1.adicionarItem(prato1);
        }

        // 13. Gerei a conta da mesa 2.
        meuRestaurante.gerarConta(2);
        
        // 14. Verifiquei se a mesa 2 também ficou livre.
        System.out.println("\n--- Verificando status geral apos fechar a conta 2 ---");
        meuRestaurante.listarMesas();
        
        // 15. Tentei gerar a conta de uma mesa que não tinha pedido.
        System.out.println("\n--- Testando gerar conta para mesa sem pedido ---");
        meuRestaurante.gerarConta(3);

        System.out.println("\n=== Fim da demonstracao, feito por Saulo Torres ===");
    }
}