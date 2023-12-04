package com.example.imdstore.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdstore.R;
import com.example.imdstore.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Produto> produtos = new ArrayList<>();
    public Adapter(List<Produto> produtos) {

        this.produtos = produtos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


            //Produto postagem = produtos.get(position);
            holder.codigo.setText(produtos.get(position).getCodigoProduto());
            holder.nome.setText(produtos.get(position).getNomeProduto());
            holder.descricao.setText(produtos.get(position).getDescricaoProduto());
            holder.estoque.setText(Integer.toString(produtos.get(position).getEstoqueProduto()));


    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView codigo;
        private TextView nome;
        private TextView descricao;
        private TextView estoque;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            codigo = itemView.findViewById(R.id.textView1);
            nome = itemView.findViewById(R.id.textView2);
            descricao = itemView.findViewById(R.id.textView3);
            estoque = itemView.findViewById(R.id.textView4);

        };

    }
}
