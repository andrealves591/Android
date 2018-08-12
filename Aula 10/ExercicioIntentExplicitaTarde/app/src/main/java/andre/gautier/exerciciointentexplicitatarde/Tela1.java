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

public class Tela1 extends AppCompatActivity {

    //Widgets
    private EditText etSite;
    private Button btNavegador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);


        //Refs
        etSite = findViewById(R.id.t1_et_site);
        btNavegador = findViewById(R.id.t1_bt_navegador);

        btNavegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent Implicita
                Uri uri = Uri.parse("http://"+etSite.getText().toString());
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
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
