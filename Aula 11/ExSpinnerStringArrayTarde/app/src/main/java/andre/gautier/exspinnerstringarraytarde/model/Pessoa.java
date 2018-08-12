package andre.gautier.exspinnerstringarraytarde.model;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private String estadoCivil;

    public Pessoa(String estadoCivil) {

        this.estadoCivil = estadoCivil;
    }

    public Pessoa() {

    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "estadoCivil = " + estadoCivil;
    }
}
