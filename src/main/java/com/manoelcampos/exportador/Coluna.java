package com.manoelcampos.exportador;

public interface Coluna {

    String getTitulo();

    String setTitulo(String titulo);

    String abrir();

    String fechar();

    String exportarCabecalho();

    Object exportarDado(Produto produto);

}
