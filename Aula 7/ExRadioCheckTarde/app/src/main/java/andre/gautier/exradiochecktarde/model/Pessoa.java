package andre.gautier.exradiochecktarde.model;

import android.content.Context;

import java.util.ArrayList;

import andre.gautier.exradiochecktarde.R;

/**
 * @author André ALves & Eduardo Gautier
 * @version 1.0 meta charset
 * @since 31/07/2018 14h21
 */
public class Pessoa {
    private String nome;
    private String sexo;
    private ArrayList<String> prefs;

    private Context context;

    public Pessoa(Context context) {
        this.context = context;
    }

    /**
     * @param nome  recebe um nome
     * @param sexo  recebe o sexo
     * @param prefs recebe as preferencias
     */
    public Pessoa(String nome, String sexo, ArrayList<String> prefs) {
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

    /**
     * @return verifica o sexo e retorna se é homem ou mulher
     */
    public String verificarSexo() {
        if (sexo.equalsIgnoreCase("Masculino")) {
            return "Você é homem!";
        } else if (sexo.equalsIgnoreCase("Feminino")) {
            return "Você é mulher!";
        }

        return "Sexo Indefinido";
    }

    @Override
    public String toString() {

        String x = "";

        for (int i = 0; i < prefs.size(); i++) {
            x += "\n" + prefs.get(i);
        }

        return
              "\n" + context.getResources().getString(R.string.ma_et_nome) + " : " + nome
            + "\n" + context.getResources().getString(R.string.ma_tv_sexo) + " : " + sexo
            + "\n" + context.getResources().getString(R.string.ma_tv_prefs) + " : " + x;
    }
}