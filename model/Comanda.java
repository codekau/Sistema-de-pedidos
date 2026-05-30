package model;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private static int contadorId = 1;
    public enum StatusComanda {
        ABERTA,
        FECHADA
    }

    private final int id;
    private List<Pedido> pedidos;
    private Mesa mesa;
    private StatusComanda status;

    public Comanda(Mesa mesa) {
        this.mesa = mesa;
        this.pedidos = new ArrayList<>();
        this.id = contadorId++;
        this.status = StatusComanda.ABERTA;
    }
    public void adicionarPedido(Pedido novoPedido) {
        validarComandaAberta();
        this.pedidos.add(novoPedido);
    }
    public void removerPedido(Pedido pedido){
        validarComandaAberta();
        if (!pedidos.remove(pedido)) {
            throw new IllegalArgumentException("Pedido não encontrado na comanda");
        }
    }
    public void fecharComanda(){
        validarComandaAberta();
        this.status = StatusComanda.FECHADA;
    }
    private void validarComandaAberta() {
        if (status != StatusComanda.ABERTA) {
            throw new IllegalStateException("Comanda não está aberta");
        }
    }
    public void mudarMesaVinculada (Mesa mesa){
        validarComandaAberta();
        if (mesa.mesaEstaLivre()){
            this.mesa = mesa;
        }
        else {
            throw new IllegalStateException("Mesa não está livre");
        }
    }
    public double calcularTotal() {
        double total = 0;

        for (Pedido p : pedidos) {
            total += p.calcularTotal();
        }

        return total;
    }
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
