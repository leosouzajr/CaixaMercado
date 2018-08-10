package com.example.leona.caixamercado.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.leona.caixamercado.R;

public class NovoProdutoActivity extends AppCompatActivity {
private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_produto);
        this.mViewHolder.etSalvarCodigo = (EditText) findViewById(R.id.et_salvar_codigo);
        this.mViewHolder.etSalvarCodigo = (EditText) findViewById(R.id.et_salvar_produto);
        this.mViewHolder.btn_salvar = (Button) findViewById(R.id.btn_salvar);
    }
    private static class ViewHolder{
        EditText etSalvarCodigo,etSalvarProduto;
        Button btn_salvar;
    }
}
