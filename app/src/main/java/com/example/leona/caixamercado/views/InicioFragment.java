package com.example.leona.caixamercado.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leona.caixamercado.R;
import com.example.leona.caixamercado.adapter.ProdutosAdapter;
import com.example.leona.caixamercado.entidades.EntidadeProduto;

import java.util.ArrayList;
import java.util.List;

// implements TextView.OnEditorActionListener
public class InicioFragment extends Fragment implements View.OnClickListener{
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inicio, container, false);
        this.mViewHolder.recyclerProdutos = (RecyclerView) view.findViewById(R.id.recycler_produtos);
        this.mViewHolder.etBusca= (EditText) view.findViewById(R.id.et_busca);
        this.mViewHolder.ivBusca= (ImageView) view.findViewById(R.id.iv_busca);

        this.setListeners();
//
//         VAMOS PODER DEFINIR ADAPTER SOMENTE NA CONSULTA
//        ProdutosAdapter adapter = new ProdutosAdapter(list);
//        this.mViewHolder.recyclerProdutos.setAdapter(adapter);
//
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
//        this.mViewHolder.recyclerProdutos.setLayoutManager(linearLayoutManager);


        return view;
    }

    private void setListeners() {
        this.mViewHolder.ivBusca.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String busca = this.mViewHolder.etBusca.getText().toString();

    }



    /*ESCONDER TECLADO
    InputMethodManager in = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
     */

    //event.getKeyCode() == KeyEvent.KEYCODE_ENTER
    //event.getAction() == KeyEvent.ACTION_DOWN

    private static class ViewHolder{
        EditText etBusca;
        ImageView ivBusca;
        RecyclerView recyclerProdutos;
    }

}
