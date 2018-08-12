package andre.gautier.exerciciosplashscreen;

import android.app.AlertDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andre.gautier.exerciciosplashscreen.model.Usuario;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etUsuario;
    private EditText etSenha;
    private Button btEntrar;
    private Button btLimpar;

    private static final String TAG = "LogsMainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Entrou oncreate, antes refs");

        //Refs
        etUsuario = findViewById(R.id.ma_et_usuario);
        etSenha = findViewById(R.id.ma_et_senha);
        btEntrar = findViewById(R.id.ma_bt_entrar);
        btLimpar = findViewById(R.id.ma_bt_limpar);

        String oi = getIntent().getStringExtra("saudacao").toString();

        if(oi != null){
            Toast.makeText(
                    getBaseContext(),
                    oi,
                    Toast.LENGTH_LONG).show();
        }

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btEntrar clique"); //AAAAAA

                Usuario u = new Usuario();

                u.setUsuario(etUsuario.getText().toString());
                u.setSenha(etSenha.getText().toString());

                AlertDialog.Builder msg = new AlertDialog.Builder(
                        MainActivity.this);
                msg.setTitle("Dados:");
                msg.setMessage(u.toString());
                msg.setIcon(ContextCompat.getDrawable(
                        MainActivity.this,
                        R.mipmap.ic_launcher));
                msg.setNeutralButton("OK", null);
                msg.show();

                limpar();
            }
        });
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "entrou no onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "entrou no onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "entrou no onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "entrou no onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "entrou no onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "entrou no onRestart");
    }


    private void limpar() {
        etUsuario.setText(null);
        etSenha.setText(null);
    }
}
