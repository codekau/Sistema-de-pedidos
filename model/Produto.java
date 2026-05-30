package model;
public class Produto {
    // CRIAÇÃO DAS VARIAVEIS
    private static int contadorId = 1;
    private int id;
    private String nome;
    private double preço;
    private boolean disponibilidade;

    // CONSTRUTOR COM VALIDAÇÃO E ID AUTOMATICO, SEMPRE INICIA PRODUTO COMO DISPONIVEL(TRUE)
    public Produto (String nome , double preço){
        validarPreço(preço);
        validarNome(nome);
        this.preço = preço;                   
        this.nome = nome.trim(); // variavel this.nome recebe nome sem "espaços" no inicio e final
        this.id = contadorId++; //Id recebe valor do contador e após isso o contador será incrementado em 1
        this.disponibilidade = true;                 
    }

    // SETTERS SIMPLES COM VALIDAÇÃO
    public void setPreço (double preço){
        validarPreço(preço);
        this.preço = preço;
    }
    public void setNome (String nome){   
        validarNome(nome);
        this.nome = nome.trim();
    }

    // METODO DE LIGA E DE DESLIGAR DISPONIBILIDADE
    public void desativarDisponibilidade (){
        this.disponibilidade = false;
    }
    public void ativarDisponibilidade (){
        this.disponibilidade = true;
    }

    // INVERTE A DISPONIBILIDADE, pensei em usa-lo em um botao de liga desliga da disponibilidade
    public void alternarDisponibilidade (){
        this.disponibilidade = !this.disponibilidade;
    }

    // VERIFICA SE ESTÁ DISPONIVEL E RETORNA TRUE SE ESTIVER
    public boolean isDisponivel(){
        return this.disponibilidade;
    }

    // GETTERS SIMPLES
    public String getNome(){
        return this.nome;
    }
    public double getPreço(){
        return this.preço;
    }
    public int getId(){
        return this.id;
    }

    // VALIDAÇÕES PARA PREÇO E NOME, POSSUEM EXCEPTIONS
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

    // ALTERAÇÃO NO METODO .EQUALS DO JAVA, estagiario que fez
    @Override
    public boolean equals(Object o) { 
        if (this == o) return true; // mesmo objeto (referencia de memoria)

        // Verifica se o objeto é nulo ou não é do tipo Produto
        if (o == null || getClass() != o.getClass()) return false;

        // Converte o objeto genérico (Object) para Produto
        // Isso é necessário porque o método equals recebe qualquer tipo de objeto
        Produto outro = (Produto) o;

        // Compara os produtos pelo ID (considerando que ID é único)
        return this.id == outro.id;
    }
    @Override    // GPT disse que sempre que mexer no equals precisa mexer nisso aqui
    public int hashCode() {
        return Integer.hashCode(id);
    }
}