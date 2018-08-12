package andre.gautier.exercicioaula11.model;

import android.widget.Toast;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String login = "root";
    private String senha = "root";

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }


    @Override
    public String toString() {
        return "\nLogin: " + login +
                "\nSenha: " + senha;
    }
}
