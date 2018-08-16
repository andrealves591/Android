package andre.gautier.exrecyclerviewtarde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import andre.gautier.exrecyclerviewtarde.adapter.ClienteAdapter;
import andre.gautier.exrecyclerviewtarde.model.Cliente;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etSexo;
    private EditText etRenda;
    private Button btOK;
    private RecyclerView rvClientes;
    private ClienteAdapter adapter;
    private ArrayList<Cliente> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.ma_et_nome);
        etSexo = findViewById(R.id.ma_et_sexo);
        etRenda = findViewById(R.id.ma_et_renda);
        btOK = findViewById(R.id.ma_bt_ok);
        rvClientes = findViewById(R.id.ma_rv_clientes);

        clientes = new ArrayList<>();
        adapter = new ClienteAdapter(MainActivity.this, clientes);

        rvClientes.setAdapter(adapter);
        rvClientes.setHasFixedSize(true);
        rvClientes.setLayoutManager(new LinearLayoutManager(this));

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente c = new Cliente();

                c.setNome(etNome.getText().toString());
                c.setSexo(etSexo.getText().toString());
                c.setRenda(Double.parseDouble(etRenda.getText().toString()));

                clientes.add(c);

                adapter.notifyDataSetChanged();

                Toast.makeText(getBaseContext(), "Cliente Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
            }
        });


        adapter.setOnItemClickListener(new ClienteAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(
                        getBaseContext(),
                        "Posição Clicada: " + position
                                + "\nCliente selecionado:\n" + clientes.get(position),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(
                        getBaseContext(),
                        "Posição Segurada: " + position
                                + "\nCliente selecionado: \n" + clientes.get(position),
                        Toast.LENGTH_LONG).show();
            }
        });
    }// fecha onCreate
}// fecha classe