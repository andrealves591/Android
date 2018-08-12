package andre.gautier.exciclodevidatarde;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import andre.gautier.exciclodevidatarde.model.Cliente;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private RadioGroup rgSexo;
    private RadioButton rdMasculino;
    private RadioButton rdFeminino;
    private CheckBox chCalabresa;
    private CheckBox chPortuguesa;
    private Button btCadastrar;

    private static final String TAG = "LogsMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Entrou oncreate, antes refs");

        etNome = findViewById(R.id.ma_et_nome);
        rgSexo = findViewById(R.id.ma_rg_sexo);
        rdMasculino = findViewById(R.id.ma_rd_masculino);
        rdFeminino = findViewById(R.id.ma_rd_feminino);
        chCalabresa = findViewById(R.id.ma_ch_calabresa);
        chPortuguesa = findViewById(R.id.ma_ch_portuguesa);
        btCadastrar = findViewById(R.id.ma_bt_cadastrar);

        Log.d(TAG, "Entrou oncreate, depois do refs");

        String oi = getIntent().getStringExtra("saudacao").toString();

        if (oi != null) {
            Toast.makeText(
                    getBaseContext(),
                    oi,
                    Toast.LENGTH_LONG).show();
        }

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "btCadastrar clique");

                Cliente c = new Cliente();

                c.setNome(etNome.getText().toString());

                if (rgSexo.getCheckedRadioButtonId() == rdMasculino.getId()) {
                    c.setSexo(rdMasculino.getText().toString());
                } else {
                    c.setSexo(rdFeminino.getText().toString());
                }

                ArrayList<String> pizzasPrefs = new ArrayList<>();
                if (chCalabresa.isChecked()) {
                    pizzasPrefs.add(chCalabresa.getText().toString());
                }
                if (chPortuguesa.isChecked()) {
                    pizzasPrefs.add(chPortuguesa.getText().toString());
                }
                c.setPrefs(pizzasPrefs);

                AlertDialog.Builder msg = new AlertDialog.Builder(
                        MainActivity.this);
                msg.setTitle("Relatório");
                msg.setMessage("Dados: " + c.toString());
                msg.setIcon(ContextCompat.getDrawable(
                        MainActivity.this,
                        R.mipmap.ic_launcher));
                msg.setNeutralButton("OK", null);
                msg.show();

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
        etNome.setText(null);

        rgSexo.clearCheck();

        chCalabresa.setChecked(false);
        chPortuguesa.setChecked(false);
    }
}