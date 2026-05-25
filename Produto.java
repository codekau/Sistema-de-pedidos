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