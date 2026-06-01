package model;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // CRIAÇÃO DAS VARIAVEIS
    private static int contadorId = 1;
    public enum StatusPedido {
        ABERTO,
        FECHADO,
        CANCELADO
    }
    private Comanda comanda;
    private int id;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private String observacao;

    // CONSTRUTOR INICIANDO OBJETO COM STATUS ABERTO E ADCIONANDO O OBJETO NA COMANDA 
    public Pedido(Comanda comanda , String observacao) {
        this.itens = new ArrayList<>();
        this.id = contadorId++;
        this.status = StatusPedido.ABERTO;
        this.observacao = observacao;
        this.comanda = comanda;
        this.comanda.adicionarPedido(this);
    }

    // ADICIONAR ITEM AO PEDIDO , SE O ITEM JA EXISTIR NO PEDIDO ELE SOMA A QUANTIDADE DELES
    public void adicionarItem(ItemPedido novoItem) {
        validarPedidoAberto();
        validarItem(novoItem);
        for (ItemPedido item : itens) {         
            if (item.getProduto().equals(novoItem.getProduto())) {  // se o item ja existir no pedido
                item.setQuantidade(item.getQuantidade() + novoItem.getQuantidade()); // soma das quantidades
                return;
            }
        }
        this.itens.add(novoItem);
    }

    // REMOVER ITEM DO PEDIDO
    public void removerItem(Produto produto) {
        validarPedidoAberto();
        itens.removeIf(item -> item.getProduto().equals(produto));
    }

    // CALCULAR TOTAL DO PEDIDO
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {  // Passa por todo os item da lista itens
            total += item.getSubTotal();
        }
        return total;
    }

    // GETTERS SIMPLES
    public int getId(){
        return this.id;
    }
    public Mesa getMesaDoPedido(){
        return this.comanda.getMesa();
    }
    public StatusPedido getStatus() {
        return this.status;
    }
    public List<ItemPedido> getItens(){
        return new ArrayList<>(itens);
    }
    public Comanda getComanda(){
        return this.comanda;
    }
    public String getObservacao(){
        return observacao;
    }
    
    // FECHAMENTO E CANCELAMENTO DE PEDIDO
    public void fecharPedido() {
        validarPedidoAberto();
        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido vazio");
        }
        this.status = StatusPedido.FECHADO;
    }
    public void cancelarPedido() {
        validarPedidoAberto();
        this.status = StatusPedido.CANCELADO;
    }

    // VALIDAÇÕES DE ITEMPEDIDO E SE O SE O PEDIDO ESTA ABERTO
    private void validarItem (ItemPedido novoItem){
        if (novoItem == null) {
            throw new IllegalArgumentException("Item inválido");
        }
    }
    private void validarPedidoAberto() {
        if (status != StatusPedido.ABERTO) {  //sempre que o status for diferente de aberto da Exception
            throw new IllegalStateException("Pedido não está aberto");
        }
    }
}
