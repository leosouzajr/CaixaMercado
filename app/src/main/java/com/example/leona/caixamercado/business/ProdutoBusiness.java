package com.example.leona.caixamercado.business;


import android.content.Context;

import com.example.leona.caixamercado.constantes.BancoDeDadosConstantes;
import com.example.leona.caixamercado.entidades.EntidadeProduto;
import com.example.leona.caixamercado.repositorio.ProdutoRepositorio;

import java.util.ArrayList;
import java.util.List;

//CLASSE QUE SERÁ UTILIZADA PARA ACESSAR O REPOSITORIO
public class ProdutoBusiness {
    //O construtor deve instanciar um objeto do produtoRepositorio

    private ProdutoRepositorio mProdutoRepositorio;

    public ProdutoBusiness(Context context) {
        this.mProdutoRepositorio = ProdutoRepositorio.getInstance(context);
    }

    //deve conter os métodos para abrir as operações do produtorepositorio
    public boolean insert(EntidadeProduto entidadeProduto){
        return this.mProdutoRepositorio.insert(entidadeProduto);
    }

    public List<EntidadeProduto> obterProdutos(String consulta){
        List<EntidadeProduto> listaProdutos = new ArrayList<>();

        listaProdutos = this.mProdutoRepositorio.obterProdutos(
                "select * from "+ BancoDeDadosConstantes.PRODUTOS.NOME_TABELA+
                    " where " + BancoDeDadosConstantes.PRODUTOS.COLUNAS.NOME_PRODUTO+
                   " like '%"+ consulta +"%';" );

        return listaProdutos;
    }
}
