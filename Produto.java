public class Produto {
    private static int contadorId = 1; // compartilhado por todos

    private int id;
    private String nome;
    private double preço;
    private boolean disponibilidade;

    public Produto (String nome , double preço){
        validarPreço(preço);
        validarNome(nome);
        this.preço = preço;                   
        this.nome = nome.trim();
        this.id = contadorId++; // gera ID automático | id vai receber o valor do contador
        this.disponibilidade = true;                 // Após isso o contador será incrementado em
    }

    public void setPreço (double preço){
        validarPreço(preço);
        this.preço = preço;
    }
    public void setNome (String nome){   
        validarNome(nome);
        this.nome = nome.trim();
    }
    public void desativarDisponibilidade (){
        this.disponibilidade = false;
    }
    public void ativarDisponibilidade (){
        this.disponibilidade = true;
    }

    public boolean isDisponivel(){
        return this.disponibilidade;
    }
    public String getNome(){
        return this.nome;
    }
    public double getPreço(){
        return this.preço;
    }
    public int getId(){
        return this.id;
    }
    public void alternarDisponibilidade (){
        this.disponibilidade = !this.disponibilidade;
    }
    private void validarPreço(double preço){
        if (preço <= 0){
            throw new IllegalArgumentException("Preço invalido");
        }
    }
    private void validarNome(String nome){
        if (nome == null || nome.trim().isEmpty()){ //Se nome for null ou conter apenas espaço
            throw new IllegalArgumentException("Nome inválido");
        }
    }
}