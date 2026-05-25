public class ItemPedido {
    
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    double getSubtotal() {
        return produto.getPreço() * quantidade;
    }

    Produto getProduto(){
        return produto;
    }
    int getQuantidade(){
        return quantidade;
    }

}
