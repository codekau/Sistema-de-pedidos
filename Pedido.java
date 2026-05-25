import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private Mesa mesa;
    private List<ItemPedido> itens;
    private String status;

    // Construtor
    public Pedido(int id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.status = "ABERTO";
    }

    // Adicionar item ao pedido
    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    // Remover item do pedido
    public void removerItem(ItemPedido item) {
        this.itens.remove(item);
    }

    // Calcular o total do pedido
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
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
    public List<ItemPedido> getItens(){
        return itens;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

}
