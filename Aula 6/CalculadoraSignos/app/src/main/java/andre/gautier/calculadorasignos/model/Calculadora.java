package andre.gautier.calculadorasignos.model;

import java.util.Random;

public class Calculadora {
    private String nome1;
    private String nome2;

    public Calculadora() {
    }

    public Calculadora(String nome1, String nome2) {
        this.nome1 = nome1;
        this.nome2 = nome2;
    }

    public String getNome1() {
        return nome1;
    }

    public void setNome1(String nome1) {
        this.nome1 = nome1;
    }

    public String getNome2() {
        return nome2;
    }

    public void setNome2(String nome2) {
        this.nome2 = nome2;
    }
    public int gerarCompatibilidade() {
        Random r = new Random();
        return r.nextInt(100);
    }


    @Override
    public String toString() {
        return "Compatibilidade: " + gerarCompatibilidade() + "%";
    }
}
