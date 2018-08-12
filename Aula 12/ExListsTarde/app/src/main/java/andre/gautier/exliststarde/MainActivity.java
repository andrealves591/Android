package andre.gautier.exliststarde;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import andre.gautier.exliststarde.adapter.ClienteAdapter;
import andre.gautier.exliststarde.model.Cliente;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private EditText etRenda;
    private RadioGroup rgSexo;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private ListView lvClientes;
    private Button btOK;

    //ArrayAdapter + ArrayList
    private ArrayList<Cliente> clientes;
    private ClienteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refs
        etNome = findViewById(R.id.ma_et_nome);
        etRenda = findViewById(R.id.ma_et_renda);
        rgSexo = findViewById(R.id.ma_rg_sexo);
        rbMasculino = findViewById(R.id.ma_rb_masculino);
        rbFeminino = findViewById(R.id.ma_rb_feminino);
        lvClientes = findViewById(R.id.ma_lv_clientes);
        btOK = findViewById(R.id.ma_bt_ok);

        clientes = new ArrayList<>(); // <<--- VAZIO!!!!!

        /*adapter = new ArrayAdapter<Cliente>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                clientes);*/

        //context,layout,array
        adapter = new ClienteAdapter(MainActivity.this, clientes);

        lvClientes.setAdapter(adapter);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cliente c = new Cliente();

                c.setNome(etNome.getText().toString());

                if (rgSexo.getCheckedRadioButtonId() == rbMasculino.getId()) {
                    c.setSexo(rbMasculino.getText().toString());
                } else {
                    c.setSexo(rbFeminino.getText().toString());
                }

                c.setRenda(Double.parseDouble(etRenda.getText().toString()));

                clientes.add(c);

                //RENDERIZA O LISTVIEW
                adapter.notifyDataSetChanged();

                Toast.makeText(
                        getBaseContext(),
                        "Cliente cadastrado com sucesso!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        lvClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Cliente c = clientes.get(position);

                /*Toast.makeText(
                        getBaseContext(),
                        "Cliente selecionado: " + c.toString(),
                        Toast.LENGTH_SHORT).show();*/
                Intent it = new Intent(MainActivity.this, DetalheCliente.class);
                it.putExtra("c", c);
                startActivity(it);

            }
        });

        lvClientes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("Atenção");
                msg.setMessage("Você realmente deseja excluir o cliente?!?!");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clientes.remove(position);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(
                                getBaseContext(),
                                "Cliente excluído com sucesso!",
                                Toast.LENGTH_LONG).show();
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();

                return true;
            }
        });
    }//fecha oncreate
}//fecha classe