public class Mesa{
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

