package andre.gautier.exercicioaula11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import andre.gautier.exercicioaula11.model.Usuario;

public class Home extends AppCompatActivity {

    private Button btCadastrar;
    private Button btContatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getIntent().getSerializableExtra("u") != null) {

            Usuario u = (Usuario) getIntent().getSerializableExtra("u");

            Toast.makeText(
                    getBaseContext(),
                    "Olá " + u.getLogin() + "!",
                    Toast.LENGTH_LONG).show();

        }
        btCadastrar = findViewById(R.id.hm_bt_cadastro);
        btContatar = findViewById(R.id.hm_bt_contato);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Home.this, Cadastro.class);
                startActivity(it);

            }
        });
        btContatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Home.this, Contato.class);
                startActivity(it);
            }
        });

    }
}
