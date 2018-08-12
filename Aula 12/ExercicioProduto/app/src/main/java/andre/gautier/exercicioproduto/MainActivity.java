package andre.gautier.exercicioproduto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import andre.gautier.exercicioproduto.adapter.ProdutoAdapter;
import andre.gautier.exercicioproduto.model.Produto;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etValor;
    private Button btOK;
    private ListView lvProdutos;

    private ArrayList<Produto> produtos;
    private ProdutoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.ma_et_nome);
        etValor = findViewById(R.id.ma_et_valor);
        lvProdutos = findViewById(R.id.ma_lv_produtos);
        btOK = findViewById(R.id.ma_bt_ok);

        produtos = new ArrayList<>();


        adapter = new ProdutoAdapter(MainActivity.this, produtos);

        lvProdutos.setAdapter(adapter);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto p = new Produto();

                p.setNome(etNome.getText().toString());

                p.setValor(Double.parseDouble(etValor.getText().toString()));

                produtos.add(p);
                adapter.notifyDataSetChanged();

                Toast.makeText(
                        getBaseContext(),
                        "Produto cadastrado com sucesso!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto p = produtos.get(position);


                Toast.makeText(
                        getBaseContext(),
                        "Produto selecionado: " + p.toString(),
                        Toast.LENGTH_SHORT).show();

            }
        });
        lvProdutos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("Atenção");
                msg.setMessage("Você deseja excluir o produto?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        produtos.remove(position);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(
                                getBaseContext(), "Produto excluído com sucesso!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();

                return true;
            }
        });
    }
}
