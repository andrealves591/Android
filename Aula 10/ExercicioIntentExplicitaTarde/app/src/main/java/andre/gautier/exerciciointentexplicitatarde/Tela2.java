package andre.gautier.exerciciointentexplicitatarde;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andre.gautier.exerciciointentexplicitatarde.model.Pessoa;

public class Tela2 extends AppCompatActivity {

    //Widgets
    private EditText etNumero;
    private Button btDiscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        etNumero = findViewById(R.id.t2_et_numero);
        btDiscador = findViewById(R.id.t2_bt_discardor);

        btDiscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent Implicita
                Uri uri = Uri.parse("tel:"+etNumero.getText().toString());
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
            }
        });
        if(getIntent().getSerializableExtra("p") != null) {

            Pessoa p = (Pessoa) getIntent().getSerializableExtra("p");

            Toast.makeText(
                    getBaseContext(),
                    "Olá " + p.getNome() + ", seja bem vindo!",
                    Toast.LENGTH_LONG).show();

        }//fecha if

    }
}
