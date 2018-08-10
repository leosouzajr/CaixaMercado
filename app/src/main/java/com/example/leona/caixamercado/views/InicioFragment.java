package com.example.leona.caixamercado.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.leona.caixamercado.R;
import com.example.leona.caixamercado.adapter.ProdutosAdapter;


public class InicioFragment extends Fragment {
    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inicio, container, false);
        this.mViewHolder.recyclerProdutos = (RecyclerView) view.findViewById(R.id.recycler_produtos);


//        ProdutosAdapter adapter = new ProdutosAdapter(list);
//        this.mViewHolder.recyclerProdutos.setAdapter(adapter);
//

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
//        this.mViewHolder.recyclerProdutos.setLayoutManager(linearLayoutManager);

        return view;
    }
    private static class ViewHolder{
        TextView tvUsuarioLogado;
        SearchView sBusca;
        RecyclerView recyclerProdutos;
    }

}
