import model.Comanda;
import model.ItemPedido;
import model.Mesa;
import model.Pedido;
import model.Produto;

public class Main {
    public static void main(String[] args) {

        // ===== CRIANDO PRODUTOS =====
        Produto coca = new Produto("Coca-Cola", 5.0);
        Produto pizza = new Produto("Pizza", 30.0);
        Produto burger = new Produto("Hamburguer", 20.0);

        // ===== CRIANDO MESA =====
        Mesa mesa1 = new Mesa(1);

        // ===== CRIANDO COMANDA =====
        Comanda comanda = new Comanda(mesa1);

        // ocupar mesa manualmente (por enquanto)
        mesa1.ocuparMesa();

        // ===== CRIANDO PEDIDO =====
        Pedido pedido1 = new Pedido(mesa1, comanda);

        // ===== ADICIONANDO ITENS =====
        pedido1.adicionarItem(new ItemPedido(coca, 2));   // 2 cocas
        pedido1.adicionarItem(new ItemPedido(pizza, 1));  // 1 pizza

        // adicionar item repetido (testar soma automática)
        pedido1.adicionarItem(new ItemPedido(coca, 1));   // +1 coca

        // ===== OUTRO PEDIDO =====
        Pedido pedido2 = new Pedido(mesa1, comanda);
        pedido2.adicionarItem(new ItemPedido(burger, 2));

        // ===== MOSTRANDO RESULTADOS =====
        System.out.println("Total Pedido 1: " + pedido1.calcularTotal());
        System.out.println("Total Pedido 2: " + pedido2.calcularTotal());

        System.out.println("Total da Comanda: " + comanda.calcularTotal());

        // ===== FECHANDO PEDIDO =====
        pedido1.fecharPedido();
        pedido2.fecharPedido();

        // ===== FECHANDO COMANDA =====
        comanda.fecharComanda();

        // ===== LIBERANDO MESA =====
        mesa1.liberarMesa();

        System.out.println("Status da mesa: " + mesa1.getStatus());
        System.out.println("Status da comanda: " + comanda.getStatus());
    }
}