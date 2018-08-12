package andre.gautier.provaandreeduardo;

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

import andre.gautier.provaandreeduardo.model.Pizzaria;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private RadioGroup rgSexo;
    private RadioButton rdMasculino;
    private RadioButton rdFeminino;
    private EditText etDDD;
    private EditText etTelefone;
    private EditText etCPF;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etRepetirSenha;
    private CheckBox chFrango;
    private CheckBox chCalabresa;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.ma_et_nome);
        rgSexo = findViewById(R.id.ma_rg_sexo);
        rdMasculino = findViewById(R.id.ma_rd_masculino);
        rdFeminino = findViewById(R.id.ma_rd_feminino);
        etDDD = findViewById(R.id.ma_et_ddd);
        etTelefone = findViewById(R.id.ma_et_telefone);
        etCPF = findViewById(R.id.ma_et_cpf);
        etEmail = findViewById(R.id.ma_et_email);
        etSenha = findViewById(R.id.ma_et_senha);
        etRepetirSenha = findViewById(R.id.ma_et_repetir_senha);
        chFrango = findViewById(R.id.ma_ch_frango);
        chCalabresa = findViewById(R.id.ma_ch_calabresa);
        btCadastrar = findViewById(R.id.ma_bt_cadastrar);


        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pizzaria p = new Pizzaria(MainActivity.this);

                p.setNome(etNome.getText().toString());

                if(rgSexo.getCheckedRadioButtonId() == rdMasculino.getId()){
                    p.setSexo(rdMasculino.getText().toString());
                }else if(rgSexo.getCheckedRadioButtonId() == rdFeminino.getId()){
                    p.setSexo(rdFeminino.getText().toString());
                }else{
                    p.setSexo("Outros");
                }

                p.setDdd(etDDD.getText().toString());
                p.setTelefone(etTelefone.getText().toString());
                p.setEmail(etEmail.getText().toString());
                p.setCpf(Long.parseLong(etCPF.getText().toString()));
                p.setSenha(etSenha.getText().toString());
                p.setRepetirSenha(etRepetirSenha.getText().toString());

                ArrayList<String> prefs = new ArrayList<>();

                if(chFrango.isChecked()){
                    prefs.add(chFrango.getText().toString());
                }else{ prefs.add("-"); }

                if(chCalabresa.isChecked()){
                    prefs.add(chCalabresa.getText().toString());
                }else{ prefs.add("-"); }

                p.setPrefs(prefs);
                limpar();
                Toast.makeText(
                        getBaseContext(),
                        "Relatório: "+p.toString() +"Verificar sexo: "+p.verificarSexo(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void limpar(){
        etNome.setText(null);
        rgSexo.clearCheck();
        etDDD.setText(null);
        etTelefone.setText(null);
        etCPF.setText(null);
        etEmail.setText(null);
        etSenha.setText(null);
        etRepetirSenha.setText(null);
        chFrango.setChecked(false);
        chCalabresa.setChecked(false);
    }
}
