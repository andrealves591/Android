package andre.gautier.provaandreeduardo.model;

import android.content.Context;

import java.util.ArrayList;

import andre.gautier.provaandreeduardo.R;

public class Pizzaria {
    private String nome;
    private String sexo;
    private String ddd;
    private String telefone;
    private long cpf;
    private String email;
    private String senha;
    private String repetirSenha;
    ArrayList<String>prefs;
    private Context context;

    public Pizzaria(Context context) {
        this.context = context;
    }

    public Pizzaria(String nome, String sexo, String ddd, String telefone, long cpf, String email, String senha, String repetirSenha, ArrayList<String> prefs) {
        this.nome = nome;
        this.sexo = sexo;
        this.ddd = ddd;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.repetirSenha = repetirSenha;
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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepetirSenha() {
        return repetirSenha;
    }

    public void setRepetirSenha(String repetirSenha) {
        this.repetirSenha = repetirSenha;
    }

    public ArrayList<String> getPrefs() {
        return prefs;
    }

    public void setPrefs(ArrayList<String> prefs) {
        this.prefs = prefs;
    }
    public String verificarSexo(){
        if(sexo.equalsIgnoreCase("Masculino")){
            return "Você é homem!";
        }else if(sexo.equalsIgnoreCase("Feminino")){
            return "Você é mulher!";
        }
        return "Sexo Indefinido";
    }

    @Override
    public String toString() {

        String x = "";

        for(int i=0 ; i<prefs.size() ; i++){
            x+= "\n"+prefs.get(i);
        }

        return
                "\n" + context.getResources().getString(R.string.ma_et_nome) + " : " + nome
                        + "\n" + context.getResources().getString(R.string.ma_tv_sexo) + " : " + sexo
                        + "\n" + context.getResources().getString(R.string.ma_et_ddd) + " : " + ddd
                        + "\n" + context.getResources().getString(R.string.ma_et_telefone) + " : " + telefone
                        + "\n" + context.getResources().getString(R.string.ma_et_cpf) + " : " + cpf
                        + "\n" + context.getResources().getString(R.string.ma_et_email) + " : " + email
                        + "\n" + context.getResources().getString(R.string.ma_et_senha) + " : " + senha
                        + "\n" + context.getResources().getString(R.string.ma_et_repetir_senha) + " : " + repetirSenha
                        + "\n" + context.getResources().getString(R.string.ma_tv_pizzas) + " : " + x;
    }
}
