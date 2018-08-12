package andre.gautier.exliststarde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import andre.gautier.exliststarde.model.Cliente;

public class DetalheCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);

        if (getIntent().getSerializableExtra("c") != null) {
            Cliente c = (Cliente) getIntent().getSerializableExtra("c");

            Toast.makeText(
                    getBaseContext(),
                    "Cliente que chegou na tela!",
                    Toast.LENGTH_SHORT).show();
        }//fecha if
    }
}
