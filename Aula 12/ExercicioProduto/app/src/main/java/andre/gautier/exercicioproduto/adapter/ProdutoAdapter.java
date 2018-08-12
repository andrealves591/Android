package andre.gautier.exercicioproduto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import andre.gautier.exercicioproduto.R;
import andre.gautier.exercicioproduto.model.Produto;

public class ProdutoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Produto>produtos;
    private LayoutInflater inflater;

    public ProdutoAdapter(Context context, ArrayList<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Produto getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if(view == null) {
            view = inflater.inflate(R.layout.linha_produto, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Produto p = getItem(i);

        holder.tvNome.setText(p.getNome());
        holder.tvValor.setText(String.valueOf(p.getValor()));

        return view;
    }

    static class ViewHolder{
        TextView tvNome;
        TextView tvValor;

        public ViewHolder(View view) {
            tvNome = view.findViewById(R.id.lp_tv_nome);
            tvValor = view.findViewById(R.id.lp_tv_valor);

        }
    }
}
