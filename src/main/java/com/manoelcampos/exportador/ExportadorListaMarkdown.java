package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

/**
 * Exporta uma tabela de objetos para o formato Markdown.
 * @author Manoel Campos da Silva Filho
 */
public class ExportadorListaMarkdown extends AbstractExportadorListaProduto {

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "\n";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
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
