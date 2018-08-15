package com.example.leona.caixamercado.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.leona.caixamercado.constantes.BancoDeDadosConstantes;
import com.example.leona.caixamercado.entidades.EntidadeProduto;

import java.util.ArrayList;
import java.util.List;

//Classe que irá abrir a conexao com o BD e
// conterá os metodos com os codigos SQL
/* O construtor ( que ira instanciar o objeto da
classe CaixaMercadoDataBaseHelper) deve
ser privado para permitir somente chamadas internas*/

public class ProdutoRepositorio {
    // deve conter duas variáveis privadas
    // a primeira representando a instancia da classe( estática)
    // a segunda um objeto da classe CaixaMercadoDataBaseHelper
    private static ProdutoRepositorio INSTANCE;
    private CaixaMercadoDataBaseHelper mCaixaMercadoDataBaseHelper;

    private ProdutoRepositorio(Context  context) {
        this.mCaixaMercadoDataBaseHelper = new CaixaMercadoDataBaseHelper(context);
    }

    public static synchronized ProdutoRepositorio getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new ProdutoRepositorio(context);
        }
        return INSTANCE;
    }

    //métodos com execução SQL


    //INSERT
    /* este método com retorno boolean deve receber como
     parametro a entidade, inicializar um objeto
      SQLiteDatabase pela chamada do getWritableDataBase
      atraves objeto da classe helper
      instanciar um ContentValues inserindo os valores
       das colunas na ordem,
      e por fim executar o insert no sQLiteDatabase passando
      (nometabela, null , contentvalues)
       */
    public boolean insert(EntidadeProduto entidadeProduto){
        boolean sucessoNaInsercao=false;
        SQLiteDatabase sqLiteDatabase = this.mCaixaMercadoDataBaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(BancoDeDadosConstantes.PRODUTOS.COLUNAS.CODIGO,
                            entidadeProduto.getCodigo());
        contentValues.put(BancoDeDadosConstantes.PRODUTOS.COLUNAS.NOME_PRODUTO,
                entidadeProduto.getProduto());

        long resposta = sqLiteDatabase.insert(BancoDeDadosConstantes.PRODUTOS.NOME_TABELA,
                null , contentValues);
        if(resposta != -1){
            sucessoNaInsercao = true;
        }

        return sucessoNaInsercao;
    }

    public List<EntidadeProduto> obterProdutos(String consulta){
        List<EntidadeProduto> listaProdutos = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase =
                this.mCaixaMercadoDataBaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(consulta,null);

        if(cursor != null && cursor.getCount() > 0){
            while (cursor.moveToNext()){
                EntidadeProduto entidadeProduto =
                        new EntidadeProduto();
                entidadeProduto.setCodigo(
                        cursor.getString(
                                cursor.getColumnIndex(
                                        BancoDeDadosConstantes.PRODUTOS.COLUNAS.CODIGO)));
                entidadeProduto.setProduto(
                        cursor.getString(
                                cursor.getColumnIndex(
                                        BancoDeDadosConstantes.PRODUTOS.COLUNAS.NOME_PRODUTO)));
                listaProdutos.add(entidadeProduto);
            }
        }
        if(cursor != null){
            cursor.close();
        }

        return listaProdutos;
    }
}
