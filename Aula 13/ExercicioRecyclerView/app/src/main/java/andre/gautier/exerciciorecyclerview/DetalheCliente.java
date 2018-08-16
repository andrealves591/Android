package andre.gautier.exerciciorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import andre.gautier.exerciciorecyclerview.model.Cliente;


public class DetalheCliente extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvSexo;
    private TextView tvRenda;
    private TextView tvFGTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);


        tvNome = findViewById(R.id.dc_tv_nome);
        tvSexo = findViewById(R.id.dc_tv_sexo);
        tvRenda = findViewById(R.id.dc_tv_renda);
        tvFGTS = findViewById(R.id.dc_tv_fgts);

        if (getIntent().getSerializableExtra("c") != null) {
            Cliente c = (Cliente) getIntent().getSerializableExtra("c");

            tvNome.setText("Nome: " + c.getNome());
            tvSexo.setText("Sexo: " + c.getSexo());
            tvRenda.setText("Renda: R$ " + String.valueOf(c.getRenda()));
            tvFGTS.setText("FGTS: R$ " + String.valueOf(c.calcularFGTS()));
        }

    }
}
