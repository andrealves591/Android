package andre.gautier.exerciciorevisao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import andre.gautier.exerciciorevisao.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etIdade;
    private RadioGroup rgSexo;
    private RadioButton rdMasculino;
    private RadioButton rdFeminino;
    private CheckBox chFutebol;
    private CheckBox chVolei;
    private CheckBox chBasquete;
    private CheckBox chPingPong;
    private Button btOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.ma_et_nome);
        etIdade = findViewById(R.id.ma_et_idade);
        rgSexo = findViewById(R.id.ma_rg_sexo);
        rdMasculino = findViewById(R.id.ma_rd_masculino);
        rdFeminino = findViewById(R.id.ma_rd_feminino);
        chFutebol = findViewById(R.id.ma_ch_futebol);
        chVolei = findViewById(R.id.ma_ch_volei);
        chBasquete = findViewById(R.id.ma_ch_basquete);
        chPingPong = findViewById(R.id.ma_ch_pingpong);
        btOK = findViewById(R.id.ma_bt_ok);


        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (etNome.getText().toString().isEmpty() || etIdade.getText().toString().isEmpty()) {
                    Pessoa p = new Pessoa(MainActivity.this);

                    p.setNome(etNome.getText().toString());
                    p.setIdade(Integer.parseInt(etIdade.getText().toString()));

                    if (rgSexo.getCheckedRadioButtonId() == rdMasculino.getId()) {
                        p.setSexo(rdMasculino.getText().toString());
                    } else if (rgSexo.getCheckedRadioButtonId() == rdFeminino.getId()) {
                        p.setSexo(rdFeminino.getText().toString());
                    } else {
                        p.setSexo("Outros");
                    }

                    ArrayList<String> prefs = new ArrayList<>();

                    if (chFutebol.isChecked()) {
                        prefs.add(chFutebol.getText().toString());
                    } else {
                        prefs.add("-");
                    }
                    if (chVolei.isChecked()) {
                        prefs.add(chVolei.getText().toString());
                    } else {
                        prefs.add("-");
                    }
                    if (chBasquete.isChecked()) {
                        prefs.add(chBasquete.getText().toString());
                    } else {
                        prefs.add("-");
                    }
                    if (chPingPong.isChecked()) {
                        prefs.add(chPingPong.getText().toString());
                    } else {
                        prefs.add("-");
                    }

                    p.setPrefs(prefs);
                    limpar();
                    Toast.makeText(
                            getBaseContext(),
                            "Relatório: " + p.toString() + "\nVerificar sexo: " + p.verificarSexo(),
                            Toast.LENGTH_LONG).show();


            }
        });
    }

    private void limpar() {
        etNome.setText(null);
        etIdade.setText(null);
        rgSexo.clearCheck();
        chFutebol.setChecked(false);
        chVolei.setChecked(false);
        chBasquete.setChecked(false);
        chPingPong.setChecked(false);
    }
}
