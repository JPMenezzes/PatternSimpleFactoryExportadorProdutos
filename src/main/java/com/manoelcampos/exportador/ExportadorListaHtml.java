package com.manoelcampos.exportador;

import java.util.List;
import java.util.function.Function;

public class ExportadorListaHtml extends AbstractExportadorListaProduto {

    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>\n";
    }

    @Override
    public String abrirLinha() {
        return " <tr>";
    }

    @Override
    public String fecharLinha() {
        return "</tr>\n";
    }

    @Override
    public String abrirLinhaTitulos() {
        return "";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "";
    }

    @Override
    public Coluna newColuna(String titulo, Function<Produto, Object> funcaoValorColuna) {
        return new ColunaHtml(titulo, funcaoValorColuna);
    }
}
