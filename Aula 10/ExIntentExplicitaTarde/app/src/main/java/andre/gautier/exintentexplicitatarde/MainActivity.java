package andre.gautier.exintentexplicitatarde;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andre.gautier.exintentexplicitatarde.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    //WIDGETS
    private EditText etNome;
    private EditText etSite;
    private Button btNavegador;

    private static final int TELA1_REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refs
        etNome = findViewById(R.id.ma_et_nome);
        etSite = findViewById(R.id.ma_et_site);
        btNavegador = findViewById(R.id.ma_bt_navegador);

        btNavegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etSite.getText().toString().isEmpty()){
                    Uri uri = Uri.parse("http://"+etSite.getText().toString());
                    Intent it = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(it);
                }
            }
        });

    }//fecha oncreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TELA1_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String frase = data.getStringExtra("frase").toString();
                Toast.makeText(
                        getBaseContext(),
                        "Frase: " + frase,
                        Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(
                        getBaseContext(),
                        "CANCELADO COM SUCESSO!",
                        Toast.LENGTH_LONG).show();
            }//fecha else if
        }//fecha if
    }//fecha onActivityResult

    public void abrirTela1(View view) {
        if (!etNome.getText().toString().isEmpty()) {

            Pessoa p = new Pessoa();
            p.setNome(etNome.getText().toString());

            Intent it = new Intent(MainActivity.this, Tela1.class);
            it.putExtra("p", p);
            startActivityForResult(it, TELA1_REQUEST_CODE);

        } else {

            Toast.makeText(
                    getBaseContext(),
                    "Preencha o campo!",
                    Toast.LENGTH_LONG).show();

        }//fecha else
    }//fecha abrirTela1
}//fecha classe