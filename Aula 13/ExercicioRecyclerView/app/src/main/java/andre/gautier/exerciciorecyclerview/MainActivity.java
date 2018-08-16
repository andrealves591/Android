package andre.gautier.exerciciorecyclerview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import andre.gautier.exerciciorecyclerview.adapter.ClienteAdapter;
import andre.gautier.exerciciorecyclerview.model.Cliente;


public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private RadioGroup rgSexo;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private EditText etRenda;
    private Button btOK;
    private RecyclerView rvClientes;

    private ArrayList<Cliente> clientes;
    private ClienteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.ma_et_nome);
        rgSexo = findViewById(R.id.ma_rg_sexo);
        rbMasculino = findViewById(R.id.ma_rb_masculino);
        rbFeminino = findViewById(R.id.ma_rb_feminino);
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
            public void onClick(View view) {

                Cliente c = new Cliente();
                c.setNome(etNome.getText().toString());

                if (rgSexo.getCheckedRadioButtonId() == rbMasculino.getId()) {
                    c.setSexo(rbMasculino.getText().toString());
                } else if (rgSexo.getCheckedRadioButtonId() == rbFeminino.getId()) {
                    c.setSexo(rbFeminino.getText().toString());
                } else {
                    c.setSexo("Outros");
                }

                c.setRenda(Double.parseDouble(etRenda.getText().toString()));

                clientes.add(c);

                adapter.notifyDataSetChanged();
                limpar();

            }//onclick
        });

        adapter.setOnItemClickListener(new ClienteAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Cliente c = clientes.get(position);

                Intent it = new Intent(MainActivity.this,
                        DetalheCliente.class);
                it.putExtra("c", c);
                startActivity(it);
            }

            @Override
            public void onItemLongClick(final int position, View v) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("Atenção");
                msg.setMessage("Você realmente deseja excluir o cliente?!?!");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        clientes.remove(position);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(
                                getBaseContext(), "Cliente excluído com sucesso!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();
            }
        });

    }

    private void limpar() {
        etNome.setText(null);
        rgSexo.clearCheck();
        etRenda.setText(null);
    }
}

