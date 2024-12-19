package com.manoelcampos.exportador;

import java.util.function.Function;

public class ColunaHtml extends AbstractColuna {

    ColunaHtml(String titulo, Function<Produto, Object> funcaoValorColuna) {
        super(titulo, funcaoValorColuna);
    }

    @Override
    public String abrir() {
        return "<td>";
    }

    @Override
    public String fechar() {
        return "</td>";
    }

}
