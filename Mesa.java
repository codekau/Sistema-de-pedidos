public class Mesa{
    private static int contadorId = 1;
    public enum StatusMesa {
        LIVRE,
        OCUPADA,
        RESERVADA,
        INDISPONIVEL
    }

    private int numero;
    private StatusMesa status;
    private final int id;


    public Mesa (int numero){
        validarNumero(numero);
        this.numero = numero;
        this.id = contadorId++;
        this.status = StatusMesa.LIVRE;
    }
    public void mudarNumero (int numero){
        if (!mesaEstaLivre()){
            throw new IllegalStateException("Mesa não está livre");
        }
        validarNumero(numero);
        this.numero = numero;
    }
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

    public StatusMesa getStatus(){
        return this.status;
    }
    public int getNumero(){
        return this.numero;
    }
    public int getId(){
        return this.id;
    }
    private void validarNumero(int numero){
        if (numero <= 0){
            throw new IllegalArgumentException("Número inválido");
        }
    }
    public boolean mesaEstaLivre(){
        return (this.status == StatusMesa.LIVRE) ;
    }
    private void validarMesaLivre(){
        if (!mesaEstaLivre()){
            throw new IllegalStateException("Mesa não está livre");
        }
    }
}

