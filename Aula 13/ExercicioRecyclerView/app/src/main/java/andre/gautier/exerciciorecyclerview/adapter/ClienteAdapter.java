package andre.gautier.exerciciorecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import andre.gautier.exerciciorecyclerview.R;
import andre.gautier.exerciciorecyclerview.model.Cliente;


public class ClienteAdapter extends RecyclerView.Adapter{

    private Context context;
    private ArrayList<Cliente> clientes;


    private static ClickListener clickListener;

    public ClienteAdapter(Context context, ArrayList<Cliente> clientes) {
        this.context = context;
        this.clientes = clientes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.linha_cliente,
                parent,
                false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder h = (ViewHolder) holder;


        Cliente c = clientes.get(position);

        h.tvNome.setText(c.getNome());
        h.tvSexo.setText(c.getSexo());
        h.tvRenda.setText(String.valueOf(c.getRenda()));

        h.tvFGTS.setText(String.valueOf(c.calcularFGTS()));

    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private final TextView tvNome;
        private final TextView tvSexo;
        private final TextView tvRenda;
        private final TextView tvFGTS;

        public ViewHolder(View itemView) {
            super(itemView);


            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            tvNome =  itemView.findViewById(R.id.lc_tv_nome);
            tvSexo =  itemView.findViewById(R.id.lc_tv_sexo);
            tvRenda =  itemView.findViewById(R.id.lc_tv_renda);
            tvFGTS =  itemView.findViewById(R.id.lc_tv_fgts);
        }

        @Override
        public void onClick(View view) {

            clickListener.onItemClick(getAdapterPosition(), view);
        }

        @Override
        public boolean onLongClick(View view) {

            clickListener.onItemLongClick(getAdapterPosition(), view);
            return true;
        }
    }


    public void setOnItemClickListener(ClickListener clickListener){
        ClienteAdapter.clickListener = clickListener;
    }


    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

}//fecha classe