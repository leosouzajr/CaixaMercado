package com.example.leona.caixamercado.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.leona.caixamercado.constantes.BancoDeDadosConstantes;

public class CaixaMercadoDataBaseHelper extends SQLiteOpenHelper{
    private static final int VERSAO_BANCO_DE_DADOS=1;
    private static final String NOME_BANCO_DE_DADOS="CaixaMercado.db";
    private static final String SQL_CRIAR_TABELA_PRODUTOS=
            "create table "+ BancoDeDadosConstantes.PRODUTOS.NOME_TABELA + "(" +
            BancoDeDadosConstantes.PRODUTOS.COLUNAS.CODIGO + " integer primary key,"+
            BancoDeDadosConstantes.PRODUTOS.COLUNAS.NOME_PRODUTO + " text);" ;
    private static final String SQL_DROP_TABELA_PRODUTOS =
            "drop table if exists " + BancoDeDadosConstantes.PRODUTOS.NOME_TABELA
                    +";";

    public CaixaMercadoDataBaseHelper(Context context) {
        super(context, NOME_BANCO_DE_DADOS, null, VERSAO_BANCO_DE_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(SQL_CRIAR_TABELA_PRODUTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_TABELA_PRODUTOS);
        sqLiteDatabase.execSQL(SQL_CRIAR_TABELA_PRODUTOS);
    }
}
