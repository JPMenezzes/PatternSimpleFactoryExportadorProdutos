package com.manoelcampos.exportador;

import java.util.function.Function;

public abstract class AbstractColuna implements Coluna {

    private String titulo;

    private Function<Produto, Object> funcaoValorColuna;

    public AbstractColuna(String titulo, Function<Produto, Object> funcaoValorColuna) {
        this.titulo = titulo;
        this.funcaoValorColuna = funcaoValorColuna;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String setTitulo(String titulo) {
        return titulo;
    }

    @Override
    public String exportarCabecalho() {
        return abrir() + getTitulo() + fechar();
    }

    @Override
    public Object exportarDado(Produto produto) {
        return abrir() + funcaoValorColuna.apply(produto) + fechar();
    }
}
