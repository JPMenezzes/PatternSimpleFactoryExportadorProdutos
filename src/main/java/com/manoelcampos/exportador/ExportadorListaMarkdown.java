package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

/**
 * Exporta uma tabela de objetos para o formato Markdown.
 */
public class ExportadorListaMarkdown extends AbstractExportadorListaProduto {

    private static final String SEPARADOR_LN = "-";

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
        StringBuilder sb = new StringBuilder();
        for (Coluna coluna : getColunas()) {
            String linha = stringRepeat(SEPARADOR_LN, coluna.getTitulo().length());
            sb.append(linha).append(ColunaMarkdown.SEPARADOR);
        }

        sb.append("\n");
        return sb.toString();
    }

    @Override
    public Coluna newColuna(String titulo, Function<Produto, Object> funcaoValorColuna) {
        return new ColunaMarkdown(titulo, funcaoValorColuna);
    }

    private String stringRepeat(String s, int repeticoes){
        return String.format("%0" + repeticoes + "d", 0).replace("0", s);
    }

}
