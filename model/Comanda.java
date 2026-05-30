package model;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private static int contadorId = 1;  // CONTADOR STATIC PARA GERAR IDs.

    // CRIAÇÃO DA VARIAVEL ENUM COM OS VALORES PRE-DEFINIDOS ABERTA e FECHADA.
    public enum StatusComanda {         
        ABERTA,
        FECHADA
    }

    // INICIALIZAÇÃO DAS VARIAVEIS
    private final int id;
    private List<Pedido> pedidos;
    private Mesa mesa;
    private StatusComanda status;

    // CONSTRUTOR RECEBENDO MESA E CRIANDO A LISTA DE PEDIDOS, ID , e INICIALIZANDO A COMANDA COMO ABERTA
    public Comanda(Mesa mesa) {
        this.mesa = mesa;
        this.pedidos = new ArrayList<>();
        this.id = contadorId++;
        this.status = StatusComanda.ABERTA;
    }

    // ADICIONAR PEDIDO A LISTA DE PEDIDOS DA COMANDA, APENAS SE A COMANDA ESTIVER ABERTA
    public void adicionarPedido(Pedido novoPedido) {
        validarComandaAberta();
        this.pedidos.add(novoPedido);
    }

    // REMOVER PEDIDO DA LISTA DA COMANDA, APENAS COM A COMANDA ABERTA
    public void removerPedido(Pedido pedido){
        validarComandaAberta();           //essa condição aqui vai apagar o pedido da lista e se nao encontra-lo ele vai 
        if (!pedidos.remove(pedido)) {    //retornar um false, quando isso ocorre o a condição fica valida e entra o exception
            throw new IllegalArgumentException("Pedido não encontrado na comanda");
        }
    }

    //VERIFICA SE ESTÁ ABERTA E FECHA A COMANDA
    public void fecharComanda(){
        validarComandaAberta();
        this.status = StatusComanda.FECHADA;
    }

    // VERIFICA SE A COMANDA ESTÁ ABERTA, RESULTARA EM EXCEPTION CASO CONTRARIO
    private void validarComandaAberta() {
        if (status != StatusComanda.ABERTA) {
            throw new IllegalStateException("Comanda não está aberta");
        }
    }

    //VINCULANDO A COMANDA A OUTRA MESA
    public void mudarMesaVinculada (Mesa mesa){
        validarComandaAberta();                  //Verifica se a comanda está aberta
        if (mesa.mesaEstaLivre()){               //Se a mesa tiver livre vai retornar true
            this.mesa = mesa;
        }
        else {
            throw new IllegalStateException("Mesa não está livre");
        }
    }

    // METÓDO PARA CALCULAR O VALOR TOTAL DA COMANDA
    public double calcularTotal() {
        double total = 0;

        for (Pedido p : pedidos) {     //Esse for aqui vai passar por todos os pedido da lista pedidos
            total += p.calcularTotal();
        }

        return total;
    }

    // GETTERS SIMPLES
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public StatusComanda getStatus() {
        return status;
    }
    public Mesa getMesa() {
        return mesa;
    }
    public int getId (){
        return this.id;
    }
    
}
