package com.example.leona.caixamercado.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leona.caixamercado.R;
import com.example.leona.caixamercado.business.ProdutoBusiness;
import com.example.leona.caixamercado.entidades.EntidadeProduto;

public class NovoProdutoActivity extends AppCompatActivity implements View.OnClickListener{
private ViewHolder mViewHolder = new ViewHolder();
private ProdutoBusiness mProdutoBusiness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_produto);
        this.mViewHolder.etSalvarCodigo = (EditText) findViewById(R.id.et_salvar_codigo);
        this.mViewHolder.etSalvarProduto = (EditText) findViewById(R.id.et_salvar_produto);
        this.mViewHolder.btn_salvar = (Button) findViewById(R.id.btn_salvar);

        this.mProdutoBusiness = new ProdutoBusiness(this);
        this.setListeners();
    }

    private void setListeners() {

        this.mViewHolder.btn_salvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String codigo =
                this.mViewHolder.etSalvarCodigo.getText().toString();
        String nome_produto =
                this.mViewHolder.etSalvarProduto.getText().toString();
        EntidadeProduto entidadeProduto =
                new EntidadeProduto(codigo,nome_produto);
        if( this.mProdutoBusiness.insert(entidadeProduto) ){
            Toast.makeText(this,
                    "Cadastro concluído com sucesso!",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,
                    "Erro no cadastro!",
                    Toast.LENGTH_SHORT).show();
        }


    }

    private static class ViewHolder{
        EditText etSalvarCodigo,etSalvarProduto;
        Button btn_salvar;
    }
}
