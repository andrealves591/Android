package andre.gautier.exentradadadostarde.model;

public class Pessoa {

    private String nome;
    private int idade;
    private double peso;

    public Pessoa() {
    }

    /**
     * @param nome  recebe um nome
     * @param idade recebe uma idade
     * @param peso  recebe um peso
     */
    public Pessoa(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int calcularIdadeMeses() {
        return idade * 12;
    }

    @Override
    public String toString() {
        return  "\nNome = " + nome +
                "\nIdade = " + idade +
                "\nPeso = " + peso +
                "\nIdade em Meses = " + calcularIdadeMeses();
    }
}//fecha classe