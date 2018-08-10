package com.example.leona.caixamercado.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leona.caixamercado.R;
import com.example.leona.caixamercado.entidades.EntidadeProduto;
import com.example.leona.caixamercado.viewholder.ProdutosViewHolder;

import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosViewHolder> {
    private List<EntidadeProduto> entidadeProdutosList;

    public ProdutosAdapter(List<EntidadeProduto> entidadeProdutosList) {
        this.entidadeProdutosList = entidadeProdutosList;
    }

    @NonNull
    @Override
    public ProdutosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View viewProdutos;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        viewProdutos = layoutInflater.inflate(R.layout.row_list_produtos, parent, false);
        return new ProdutosViewHolder(viewProdutos);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutosViewHolder holder, int position) {
        EntidadeProduto entidadeProduto = this.entidadeProdutosList.get(position);
        holder.preencherDados(entidadeProduto);
    }

    @Override
    public int getItemCount() {
        return this.entidadeProdutosList.size();
    }
}
