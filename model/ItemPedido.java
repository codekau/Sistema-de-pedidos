package model;
public class ItemPedido {
    
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        validarQuantidade(quantidade);
        validarProduto(produto);
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public void setQuantidade(int quantidade){
        validarQuantidade(quantidade);
        this.quantidade = quantidade;
    }
    public double getSubTotal() {
        return produto.getPreço() * quantidade;
    }
    public Produto getProduto(){
        return produto;
    }
    public int getQuantidade(){
        return quantidade;
    }
    
    private void validarQuantidade(int quantidade){
        if (quantidade <= 0){
            throw new IllegalArgumentException("Quantidade invalida");
        }
    }
    private void validarProduto(Produto produto){
        if (produto == null){
            throw new IllegalArgumentException("Produto invalido (null)");
        }
        if (!produto.isDisponivel()){
            throw new IllegalArgumentException("Produto indisponivel");
        }
    }
}
