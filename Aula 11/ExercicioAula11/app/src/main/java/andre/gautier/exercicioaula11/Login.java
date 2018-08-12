package andre.gautier.exercicioaula11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andre.gautier.exercicioaula11.model.Usuario;

public class Login extends AppCompatActivity {

    private EditText etLogin;
    private EditText etSenha;
    private Button btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = findViewById(R.id.lg_et_login);
        etSenha = findViewById(R.id.lg_et_senha);
        btEntrar = findViewById(R.id.lg_bt_entrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etLogin.getText().toString().isEmpty() && !etSenha.getText().toString().isEmpty()) {

                    Usuario u = new Usuario();

                    u.setLogin(etLogin.getText().toString());
                    u.setSenha(etSenha.getText().toString());

                    Intent it = new Intent(Login.this, Home.class);
                    it.putExtra("u", u);
                    startActivity(it);


                } else {

                    Toast.makeText(
                            getBaseContext(),
                            "Preencha os campos vazios!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
