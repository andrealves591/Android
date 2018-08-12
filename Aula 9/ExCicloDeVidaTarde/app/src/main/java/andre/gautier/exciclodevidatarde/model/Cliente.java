package andre.gautier.exciclodevidatarde.model;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String sexo;
    private ArrayList<String> prefs;

    public Cliente() {
    }

    public Cliente(String nome, String sexo, ArrayList<String> prefs) {
        this.nome = nome;
        this.sexo = sexo;
        this.prefs = prefs;
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

    public ArrayList<String> getPrefs() {
        return prefs;
    }

    public void setPrefs(ArrayList<String> prefs) {
        this.prefs = prefs;
    }

    @Override
    public String toString() {
        return "\nnome = " + nome +
                "\nsexo = " + sexo +
                "\nprefs = " + prefs;
    }
}
