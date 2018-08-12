package andre.gautier.exerciciorevisao.model;

import android.content.Context;

import java.util.ArrayList;

import andre.gautier.exerciciorevisao.R;

public class Pessoa {
    private String nome;
    private int idade;
    private String sexo;
    ArrayList<String> prefs;
    private Context context;

    public Pessoa(Context context) {
        this.context = context;
    }

    public Pessoa(String nome, int idade, String sexo, ArrayList<String> prefs) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.prefs = prefs;
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

    public String verificarSexo() {
        if (sexo.equalsIgnoreCase("Masculino")) {
            return "Homem!";
        } else if (sexo.equalsIgnoreCase("Feminino")){
            return "Mulher!";
        }
        return "Sexo Indefinido";
    }

    public int calcularIdadeMeses() {
        return idade * 12;
    }

    @Override
    public String toString() {

        String x = "";

        for (int i = 0; i < prefs.size(); i++) {
            x += "\n" + prefs.get(i);
        }

        return
                "\n" + context.getResources().getString(R.string.ma_et_nome) + " : " + nome
                        + "\n" + context.getResources().getString(R.string.ma_et_idade) + " : " + idade
                        + "\n" + context.getResources().getString(R.string.ma_tv_sexo) + " : " + sexo
                        + "\n" + context.getResources().getString(R.string.ma_tv_prefs) + " : " + x;
    }
}
