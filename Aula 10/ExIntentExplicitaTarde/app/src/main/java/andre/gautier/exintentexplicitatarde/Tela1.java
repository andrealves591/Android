package andre.gautier.exintentexplicitatarde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andre.gautier.exintentexplicitatarde.model.Pessoa;

public class Tela1 extends AppCompatActivity {

    //Widgets
    private EditText etFrase;
    private Button btOK;
    private Button btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Refs
        etFrase = findViewById(R.id.t1_et_frase);
        btOK = findViewById(R.id.t1_bt_ok);
        btCancelar = findViewById(R.id.t1_bt_cancelar);

        //RECEBENDO OS VALORE DO MAIN ACTIVITY
        if (getIntent().getSerializableExtra("p") != null) {
            Pessoa p = (Pessoa) getIntent().getSerializableExtra("p");
            Toast.makeText(
                    getBaseContext(),
                    "Olá " + p.getNome() + ", seja bem vindo!",
                    Toast.LENGTH_LONG).show();
        }//fecha if

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etFrase.getText().toString().isEmpty()) {
                    Intent it = new Intent();
                    it.putExtra("frase", etFrase.getText().toString());
                    setResult(RESULT_OK, it);
                    finish();
                } else {
                    Toast.makeText(
                            getBaseContext(),
                            "Digite a frase, negrão!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }//fecha oncreate
}//fecha classe