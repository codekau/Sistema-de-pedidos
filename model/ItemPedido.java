package model;
public class ItemPedido {
    
    private Produto produto;
    private int quantidade;

    //CONSTRUTOR VERIFICA SE O PRODUTO E QUANTIDADE SAO VALIDOS E CRIA OBJETO
    public ItemPedido(Produto produto, int quantidade) {
        validarQuantidade(quantidade);
        validarProduto(produto);
        this.produto = produto;
        this.quantidade = quantidade;
    }

    //ALTERA A QUANTIDADE DIRETAMENTE APOS VALIDAÇÃO,   pensei que seria iteressante ter um metodo para
    public void setQuantidade(int quantidade){       // alterar a quatidade do produto mesmo após a criação
        validarQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    // GETTER SIMPLES
    public double getSubTotal() {
        return produto.getPreço() * quantidade;
    }
    public Produto getProduto(){
        return produto;
    }
    public int getQuantidade(){
        return quantidade;
    }

    // VERIFICA SE A QUANTIDADE É UM NUMERO MAIOR QUE 0, CASO CONTRARIO EXCEPTION
    private void validarQuantidade(int quantidade){
        if (quantidade <= 0){
            throw new IllegalArgumentException("Quantidade invalida");
        }
    }

    // VERIFICA SE O PRODUTO ESTA DISPONIVEL E NÃO É UM OBJETO NULL, CASO CONTRARIO EXCEPTION
    private void validarProduto(Produto produto){
        if (produto == null){
            throw new IllegalArgumentException("Produto invalido (null)");
        }
        if (!produto.isDisponivel()){
            throw new IllegalArgumentException("Produto indisponivel");
        }
    }
}
