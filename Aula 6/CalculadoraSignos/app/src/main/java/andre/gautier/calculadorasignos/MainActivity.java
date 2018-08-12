package andre.gautier.calculadorasignos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import andre.gautier.calculadorasignos.model.Calculadora;

public class MainActivity extends AppCompatActivity {

    private EditText etNome1;
    private EditText etNome2;
    private Button btCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome1 = findViewById(R.id.ma_et_nome);
        etNome2 = findViewById(R.id.ma_et_nome2);
        btCalcular = findViewById(R.id.ma_bt_calcular);


        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(etNome1.getText().toString().isEmpty() || etNome2.getText().toString().isEmpty())) {

                    Calculadora c = new Calculadora();


                    c.setNome1(etNome1.getText().toString());
                    c.setNome2(etNome2.getText().toString());

                    Toast.makeText(
                            getBaseContext(),
                            c.toString(),
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(
                            getBaseContext(),
                            "Algum dos campos está vazio",
                            Toast.LENGTH_LONG).show();

                }

            }//fecha onClick
        });
    }//fecha oncreate

    private void limpar() {
        etNome1.setText("");
        etNome2.setText("");
    }
}//fecha classe
