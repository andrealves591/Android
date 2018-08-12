package andre.gautier.exliststarde.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import andre.gautier.exliststarde.R;
import andre.gautier.exliststarde.model.Cliente;

public class ClienteAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Cliente> clientes;
    private LayoutInflater inflater;

    public ClienteAdapter(Context context, ArrayList<Cliente> clientes) {

        this.context = context;
        this.clientes = clientes;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Cliente getItem(int position) {
        return clientes.get(position);
    }

    @Override   //NAO USA!
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder holder;

        if(view == null) {
            view = inflater.inflate(R.layout.linha_cliente, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Cliente c = getItem(i);

        holder.tvNome.setText(c.getNome());
        holder.tvSexo.setText(c.getSexo());
        holder.tvRenda.setText(String.valueOf(c.getRenda()));

        return view;
    }//fecha getView


    static class ViewHolder{
        TextView tvNome;
        TextView tvSexo;
        TextView tvRenda;

        public ViewHolder(View view) {
            tvNome = view.findViewById(R.id.lc_tv_nome);
            tvSexo = view.findViewById(R.id.lc_tv_sexo);
            tvRenda = view.findViewById(R.id.lc_tv_renda);
        }
    }
}//fecha classe