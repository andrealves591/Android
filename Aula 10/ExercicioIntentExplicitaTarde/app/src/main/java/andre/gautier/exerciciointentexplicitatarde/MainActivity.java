package andre.gautier.exerciciointentexplicitatarde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andre.gautier.exerciciointentexplicitatarde.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private Button btTela1;
    private Button btTela2;


    //RequestCode
    private static final int TELA1_REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.ma_et_nome);
        btTela1 = findViewById(R.id.ma_bt_tela1);
        btTela2 = findViewById(R.id.ma_bt_tela2);


        btTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!etNome.getText().toString().isEmpty()) {

                    Pessoa p = new Pessoa();
                    p.setNome(etNome.getText().toString());

                    Intent it = new Intent(MainActivity.this, Tela1.class);
                    it.putExtra("p", p);
                    startActivity(it);

                } else {

                    Toast.makeText(
                            getBaseContext(),
                            "preencha o nome!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!etNome.getText().toString().isEmpty()) {

                    Pessoa p = new Pessoa();
                    p.setNome(etNome.getText().toString());

                    Intent it = new Intent(MainActivity.this, Tela2.class);
                    it.putExtra("p", p);
                    startActivity(it);

                } else {

                    Toast.makeText(
                            getBaseContext(),
                            "Preencha o nome!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
