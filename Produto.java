public class Produto {
    private static int contadorId = 1; // compartilhado por todos

    private int id;
    private String nome;
    private double preço;
    private boolean disponibilidade;

    public Produto (String nome , double preço){
        this.id = contadorId++; // gera ID automático | id vai receber o valor do contador
        setPreço(preço);                             // Após isso o contador será incrementado em 1
        setNome(nome);
        this.disponibilidade = true;
    }

    void setPreço (double preço){
        if (preço > 0){
            this.preço = preço;
        }
        else {
            System.out.println("Preço inválido");
        }
    }
    void setNome (String nome){   
        if (nome != null && !nome.trim().isEmpty()){ //nome não pode ser nulo e nem coter apenas espaço
            this.nome = nome;
        }
        else {
            System.out.println("Nome inválido");
        }
    }
    void setDisponibilidade (boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    boolean isDisponibilidade(){
        return this.disponibilidade;
    }
    String getNome(){
        return this.nome;
    }
    double getPreço(){
        return this.preço;
    }
    int getId(){
        return this.id;
    }
    void alterarDisponibilidade (){
        this.disponibilidade = !this.disponibilidade;
    }
}