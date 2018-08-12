package andre.gautier.exercicioaula11.model;

import java.io.Serializable;

public class Produto implements Serializable{
    private String nome;
    private String categoria;
    private double tamanho;

    public Produto(String nome, String categoria, double tamanho) {
        this.nome = nome;
        this.categoria = categoria;
        this.tamanho = tamanho;
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nCategoria: " + categoria +
                "\nTamanho: " + tamanho;
    }
}
