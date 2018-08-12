package andre.gautier.exentradadadostarde;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andre.gautier.exentradadadostarde.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    //WIDGETS
    private EditText etNome;
    private EditText etIdade;
    private EditText etPeso;
    private Button btOK;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refs
        etNome = findViewById(R.id.ma_et_nome);
        etIdade = findViewById(R.id.ma_et_idade);
        etPeso = findViewById(R.id.ma_et_peso);
        btOK = findViewById(R.id.ma_bt_ok);
        btLimpar = findViewById(R.id.ma_bt_limpar);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa p = new Pessoa();
                p.setNome(etNome.getText().toString());

                p.setIdade(Integer.parseInt(etIdade.getText().toString()));
                p.setPeso(Double.parseDouble(etPeso.getText().toString()));

                limpar();

                /*Toast.makeText(
                        getBaseContext(),
                        "Relatório" + p.toString(),
                        Toast.LENGTH_LONG).show();*/

                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
                msg.setMessage(p.toString());
                msg.setPositiveButton(getResources().getText(R.string.ma_alert_ok), null);
                msg.show();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });

    }//fecha onCreate

    private void limpar() {
        etNome.setText("");
        etIdade.setText("");
        etPeso.setText("");
        etNome.requestFocus();
    }
}//fecha classe