package model;
public class Mesa{

    //CRIAÇÃO DO CONTADOR PARA OS IDs E DO ENUM COM VALORES PRÉ-DEFINIDOS
    private static int contadorId = 1;
    public enum StatusMesa {
        LIVRE,
        OCUPADA,
        RESERVADA,
        INDISPONIVEL
    }

    // INICIALIZAÇÃO DAS VARIAVEIS
    private int numero;
    private StatusMesa status;
    private final int id;
    private int capacidade;
    private Comanda comanda;

    // CONSTRUTOR GERANDO ID AUTOMATICO E INICIANDO COM STATUS DE LIVRE
    public Mesa (int numero , int capacidade){
        validarNumero(numero);
        this.numero = numero;
        this.capacidade = capacidade;
        this.id = contadorId++;
        this.status = StatusMesa.LIVRE;
    }

    // METODO PARA ALTERAR O NUMERO DA MESA
    public void mudarNumero (int numero){
        if (!mesaEstaLivre()){   // Impedir alterações de variavel se a mesa estiver em uso para evitar erros
            throw new IllegalStateException("Mesa não está livre");
        }
        validarNumero(numero);
        this.numero = numero;
    }

    // METODOS PARA ALTERAR O STATUS DA MESA APÓS VALIDAÇÃO, MAIORIA COM EXCEPTIONS
    public void ocuparMesa(){
        validarMesaLivre();
        this.status = StatusMesa.OCUPADA;
    }
    public void liberarMesa(){
        if (this.status == StatusMesa.LIVRE){
            throw new IllegalStateException("Mesa já está livre");
        }
        this.status = StatusMesa.LIVRE;
    }
    public void reservarMesa(){
        validarMesaLivre();
        this.status = StatusMesa.RESERVADA;
    }
    public void ocuparMesaReservada(){
        if (status != StatusMesa.RESERVADA){
            throw new IllegalStateException("Mesa não está reservada");
        }
        this.status = StatusMesa.OCUPADA;
    }
    public void indisponibilizarMesa(){
        validarMesaLivre();
        this.status = StatusMesa.INDISPONIVEL;
    }

    // GETTERS SIMPLES
    public int getCapacidade(){
        return this.capacidade;
    }
    public StatusMesa getStatus(){
        return this.status;
    }
    public int getNumero(){
        return this.numero;
    }
    public int getId(){
        return this.id;
    }
    
    // RETORNA TRUE SEMPRE QUE MESA FOR LIVRE
    public boolean mesaEstaLivre(){
        return (this.status == StatusMesa.LIVRE) ;
    }

    //MODIFICADOR DE CAPACIDADE (caso precise editar apos a criação)
    public void modificarCapacidade(int capacidade){
        validarNumero(capacidade);
        this.capacidade = capacidade;
    }
    
    // VALIDAÇÕES PARA NUMERO E MESA LIVRE, POSSUEM EXCEPTIONS
    private void validarNumero(int numero){
        if (numero <= 0){
            throw new IllegalArgumentException("Número inválido");
        }
    }
    private void validarMesaLivre(){
        if (!mesaEstaLivre()){
            throw new IllegalStateException("Mesa não está livre");
        }
    }

    //ALTERAÇÕES NA COMANDA VINCULADA
    public void abrirComanda() {
        validarMesaLivre();
        this.comanda = new Comanda(this);
        this.status = StatusMesa.OCUPADA;
    }

    public void fecharComanda() {
        if (this.comanda == null) {
            throw new IllegalStateException("Mesa não possui comanda");
        }
        this.comanda.fecharComanda();
        this.comanda = null;
        this.status = StatusMesa.LIVRE;
    }
}

