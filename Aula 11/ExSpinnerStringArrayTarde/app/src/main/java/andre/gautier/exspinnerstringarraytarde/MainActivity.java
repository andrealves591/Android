package andre.gautier.exspinnerstringarraytarde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import andre.gautier.exspinnerstringarraytarde.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private Spinner spEstadoCivil;
    private Button btOK;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spEstadoCivil = findViewById(R.id.ma_sp_estado_civil);
        btOK = findViewById(R.id.ma_bt_ok);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spEstadoCivil.getSelectedItemPosition() != 0){
                    Pessoa p = new Pessoa();
		    p.setEstadoCivil(spEstadoCivil.getSelectedItem().toString());
                    toast("est. civil:"+ p.getEstadoCivil());
                } else {
                    toast("Selecione uma opção!");
                }
            }
        });

    }

    private void toast(String msg){
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }
}