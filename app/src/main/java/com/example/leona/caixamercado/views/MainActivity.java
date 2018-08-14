package com.example.leona.caixamercado.views;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.leona.caixamercado.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    InicioFragment inicioFragment;
    private static ViewHolder mViewHolder= new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarFragment("inicio");
        this.mViewHolder.fabAbrirCadastro = (FloatingActionButton) findViewById(R.id.fab_abrir_cadastro);
        this.setListeners();
    }

    private void setListeners() {
        this.mViewHolder.fabAbrirCadastro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
           int id = view.getId();
           if(id == R.id.fab_abrir_cadastro){
               startActivity(new Intent(this,
                       NovoProdutoActivity.class));
           }
    }

    private void carregarFragment(String tipoFragment) {
        if (tipoFragment.equalsIgnoreCase("inicio")) {

            inicioFragment = new InicioFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, inicioFragment).commit();
        }

    }



    private static class ViewHolder{
        FloatingActionButton fabAbrirCadastro;
    }
}
