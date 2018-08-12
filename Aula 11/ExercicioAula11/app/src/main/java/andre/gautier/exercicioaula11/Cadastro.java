package andre.gautier.exercicioaula11;

import android.app.AlertDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import andre.gautier.exercicioaula11.model.Produto;

public class Cadastro extends AppCompatActivity {

    private EditText etNome;
    private Spinner spCategoria;
    private EditText etTamanho;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.cad_et_nome);
        spCategoria = findViewById(R.id.cad_sp_categoria);
        etTamanho = findViewById(R.id.cad_et_tamanho);
        btCadastrar = findViewById(R.id.cad_bt_cadastrar);


        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spCategoria.getSelectedItemPosition() != 0) {
                    Produto p = new Produto();
                    p.setNome(etNome.getText().toString());
                    p.setCategoria(spCategoria.getSelectedItem().toString());
                    p.setTamanho(Double.parseDouble(etTamanho.getText().toString()));
                    AlertDialog.Builder msg = new AlertDialog.Builder(Cadastro.this);
                    msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
                    msg.setMessage(p.toString());
                    msg.setIcon(ContextCompat.getDrawable(
                            Cadastro.this,
                            R.mipmap.ic_launcher));
                    msg.setPositiveButton(getResources().getText(R.string.ma_alert_ok), null);
                    msg.show();
                } else {
                    Toast.makeText(getBaseContext(), "Selecione uma categoria!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
