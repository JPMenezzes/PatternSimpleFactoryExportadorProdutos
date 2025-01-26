package com.manoelcampos.exportador;

import java.util.function.Function;

public class ColunaMarkdown extends AbstractColuna {

    public static final String SEPARADOR = "|";

    public ColunaMarkdown(String titulo, Function<Produto, Object> funcaoValorColuna) {
        super(titulo, funcaoValorColuna);
    }

    @Override
    public String abrir() {
        return "";
    }

    @Override
    public String fechar() {
        return " " + SEPARADOR;
    }
}
