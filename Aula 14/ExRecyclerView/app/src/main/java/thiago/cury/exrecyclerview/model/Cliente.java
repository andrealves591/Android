package thiago.cury.exrecyclerview.model;

public class Cliente {

    private String key;
    private String nome;
    private String sexo;
    private double renda;

    public Cliente() {
    }

    public Cliente(String key, String nome, String sexo, double renda) {
        this.key = key;
        this.nome = nome;
        this.sexo = sexo;
        this.renda = renda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public double calcularFGTS() {
        return renda * 0.08;
    }

    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

    @Override
    public String toString() {
        return "Id = " + key +
                "\nnome = " + nome +
                "\nsexo = " + sexo +
                "\nrenda = " + renda;
    }
}//fecha classe