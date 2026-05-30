import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorId = 1;
    public enum StatusPedido {
        ABERTO,
        FECHADO,
        CANCELADO
    }

    private Comanda comanda;
    private int id;
    private Mesa mesa;
    private List<ItemPedido> itens;
    private StatusPedido status;

    // Construtor
    public Pedido(Mesa mesa , Comanda comanda) {
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.id = contadorId++;
        this.status = StatusPedido.ABERTO;
        this.comanda = comanda;
        comanda.adicionarPedido(this);
    }

    // Adicionar item ao pedido
    public void adicionarItem(ItemPedido novoItem) {
        validarPedidoAberto();
        validarItem(novoItem);

        for (ItemPedido item : itens) {
            if (item.getProduto().equals(novoItem.getProduto())) {
                item.setQuantidade(item.getQuantidade() + novoItem.getQuantidade());
                return;
            }
        }
        this.itens.add(novoItem);
    }

    // Remover item do pedido
    public void removerItem(Produto produto) {
        validarPedidoAberto();
        itens.removeIf(item -> item.getProduto().equals(produto));
    }

    // Calcular o total do pedido
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubTotal();
        }
        return total;
    }
    // Getters e Setters
    public int getId(){
        return id;
    }
    public Mesa getMesa(){
        return mesa;
    }
    public StatusPedido getStatus() {
        return status;
    }
    public List<ItemPedido> getItens(){
        return new ArrayList<>(itens);
    }
    
    private void validarItem (ItemPedido novoItem){
        if (novoItem == null) {
            throw new IllegalArgumentException("Item inválido");
        }
    }
    public void fecharPedido() {
        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido vazio");
        }
        this.status = StatusPedido.FECHADO;
    }
    public void cancelarPedido() {
        validarPedidoAberto();
        this.status = StatusPedido.CANCELADO;
    }
    private void validarPedidoAberto() {
        if (status != StatusPedido.ABERTO) {
            throw new IllegalStateException("Pedido não está aberto");
        }
    }
}
