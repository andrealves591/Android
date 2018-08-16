package thiago.cury.exrecyclerview;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import thiago.cury.exrecyclerview.adapter.ClienteAdapter;
import thiago.cury.exrecyclerview.model.Cliente;

public class MainActivity extends AppCompatActivity {

    //Widgets
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

        initialize();//metodo para referenciar atributos

        clientes = new ArrayList<>();
        adapter = new ClienteAdapter(MainActivity.this, clientes);

        rvClientes.setAdapter(adapter);

        rvClientes.setHasFixedSize(true);
        rvClientes.setLayoutManager(new LinearLayoutManager(this));

        FirebaseApp.initializeApp(MainActivity.this);
        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference banco = db.getReference("clientes");

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cliente c = new Cliente();
                c.setNome(etNome.getText().toString());
                if(rgSexo.getCheckedRadioButtonId() == rbMasculino.getId()){
                    c.setSexo(rbMasculino.getText().toString());
                }else{
                   c.setSexo(rbFeminino.getText().toString());
                }
                c.setRenda(Double.parseDouble(etRenda.getText().toString()));

                banco.push().setValue(c);//Enviando obj para o Firebase

                Toast.makeText(
                        getBaseContext(),
                        "Cliente cadastrado com sucesso!",
                        Toast.LENGTH_SHORT).show();

            }//onclick
        });//onclick do btOK

        adapter.setOnItemClickListener(new ClienteAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(
                        getBaseContext(),
                        "Clicou na posiçao: "+position +
                        "\ncliente: "+clientes.get(position),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(final int position, View v) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("Alerta");
                msg.setMessage("Você deseja excluir o cliente?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Cliente c = clientes.get(position);

                        //Removendo através da chave(key) no firebase
                        banco.child(c.getKey()).removeValue();

                        clientes.remove(position);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(
                                getBaseContext(),
                                "Cliente excluído com sucesso!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();
            }
        });

        banco.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clientes.clear();
                for (DataSnapshot data: dataSnapshot.getChildren()) {
                    Cliente c = data.getValue(Cliente.class);
                    c.setKey(data.getKey());
                    clientes.add(c);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }//fecha oncreate

    private void initialize(){
        //Refs
        etNome = findViewById(R.id.ma_et_nome);
        rgSexo = findViewById(R.id.ma_rg_sexo);
        rbMasculino = findViewById(R.id.ma_rb_masculino);
        rbFeminino = findViewById(R.id.ma_rb_feminino);
        etRenda = findViewById(R.id.ma_et_renda);
        btOK = findViewById(R.id.ma_bt_ok);
        rvClientes = findViewById(R.id.ma_rv_clientes);
    }
}//fecha classe
