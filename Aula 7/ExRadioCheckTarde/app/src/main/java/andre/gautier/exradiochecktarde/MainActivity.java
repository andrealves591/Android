package andre.gautier.exradiochecktarde;

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

import andre.gautier.exradiochecktarde.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private RadioGroup rgSexo;
    private RadioButton rdMasculino;
    private RadioButton rdFeminino;
    private CheckBox chAnime;
    private CheckBox chManga;
    private Button btOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refs
        etNome = findViewById(R.id.ma_et_nome);
        rgSexo = findViewById(R.id.ma_rg_sexo);
        rdMasculino = findViewById(R.id.ma_rd_masculino);
        rdFeminino = findViewById(R.id.ma_rd_feminino);
        chAnime = findViewById(R.id.ma_ch_anime);
        chManga = findViewById(R.id.ma_ch_manga);
        btOK = findViewById(R.id.ma_bt_ok);


        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!etNome.getText().toString().isEmpty()) {

                    Pessoa p = new Pessoa(MainActivity.this);

                    p.setNome(etNome.getText().toString());
                    if (rgSexo.getCheckedRadioButtonId() == rdMasculino.getId()) {
                        p.setSexo(rdMasculino.getText().toString());
                    } else if (rgSexo.getCheckedRadioButtonId() == rdFeminino.getId()) {
                        p.setSexo(rdFeminino.getText().toString());
                    } else {
                        p.setSexo("Outros");
                    }//fecha else

                    ArrayList<String> prefs = new ArrayList<>();

                    if (chAnime.isChecked()) {
                        prefs.add(chAnime.getText().toString());
                    } else {
                        prefs.add("-");
                    }

                    if (chManga.isChecked()) {
                        prefs.add(chManga.getText().toString());
                    } else {
                        prefs.add("-");
                    }

                    p.setPrefs(prefs);

                    limpar();

                    Toast.makeText(getBaseContext(),
                            p.toString() + "\nVerificar Sexo: " + p.verificarSexo(),
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(),
                            "Preenchimento de formulário incompleto!",
                            Toast.LENGTH_LONG).show();
                }
            }//fecha onClick
        });//fecha onClickListener

    }//fecha onCreate

    private void limpar() {
        etNome.setText(null);
        rgSexo.clearCheck();
        chAnime.setChecked(false);
        chManga.setChecked(false);
    }//fecha limpar

}//fecha classe
