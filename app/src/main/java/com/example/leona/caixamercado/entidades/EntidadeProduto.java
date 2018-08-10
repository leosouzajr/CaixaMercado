package com.example.leona.caixamercado.entidades;

public class EntidadeProduto {
    String codigo,produto;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public EntidadeProduto(String codigo, String produto) {
        this.codigo = codigo;
        this.produto = produto;
    }
}
