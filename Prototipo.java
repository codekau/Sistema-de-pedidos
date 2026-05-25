
import java.util.List;
import java.util.ArrayList;
public class Prototipo {
    
}
class Produto {
    private String nome;
    private double preço;

    public Produto (String nome , double preço){
        setPreço(preço);
        setNome(nome);
    }
    void setPreço (double preço){
        if (preço > 0){
            this.preço = preço;
        }
        //codigo de erro
    }
    void setNome (String nome){   //ta faltando condição de validação
        this.nome = nome;
    }
    String getNome(){
        return this.nome;
    }
    double getPreço(){
        return this.preço;
    }
}


class Mesa{
    private int numero;
    private String status;
    public Mesa (int numero , String status){
        setNumero(numero);
        setStatus(status);
    }
    void setNumero (int numero){
        if (numero > 0){
            this.numero = numero;
        }
        //codigo de erro
    }
    void setStatus (String status){   // Status pode ser algo como 3 opçoes de entrada no front: LIVRE , OCUPADA , INDISPONIVEL
        this.status = status;         //ta faltando condição de validação
    }
    String getStatus(){
        return this.status;
    }
    int getNumero(){
        return this.numero;
    }
}


class ItemPedido{
    
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


class Pedido {

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