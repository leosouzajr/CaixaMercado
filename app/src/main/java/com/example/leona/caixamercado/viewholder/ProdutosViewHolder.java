package com.example.leona.caixamercado.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.leona.caixamercado.R;
import com.example.leona.caixamercado.entidades.EntidadeProduto;

public class ProdutosViewHolder extends RecyclerView.ViewHolder {
    TextView tvProduto, tvCodigo;

    public ProdutosViewHolder(View itemView) {
        super(itemView);
        this.tvCodigo = itemView.findViewById(R.id.tv_codigo);
        this.tvProduto = itemView.findViewById(R.id.tv_produto);
    }

    public void preencherDados(EntidadeProduto entidadeProduto) {
             tvProduto.setText(entidadeProduto.getProduto());
             tvCodigo.setText(entidadeProduto.getCodigo());
    }
}
