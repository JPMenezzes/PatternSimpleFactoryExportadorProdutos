package com.manoelcampos.exportador;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Classe abstrata que fornece uma implementação base para as subclasses
 * que definem formatos específicos de exportação de dados.
 */
public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {

    private List<Coluna> colunas = new ArrayList<>();

    public AbstractExportadorListaProduto() {
        addNewColuna("id", Produto::getId);
        addNewColuna("descricao", Produto::getDescricao);
        addNewColuna("marca", Produto::getMarca);
        addNewColuna("modelo", Produto::getModelo);
        addNewColuna("estoque", Produto::getEstoque);
    }

    @Override
    public String exportar(List<Produto> produtos) {
        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());
        exportarTitulosColunas(sb);
        exportarLinhas(produtos, sb);

        sb.append(fecharTabela());
        return sb.toString();
    }

    private void exportarTitulosColunas(StringBuilder sb) {
        sb.append(abrirLinha());
        for (Coluna coluna : colunas) {
            sb.append(coluna.exportarCabecalho());
        }
        sb.append(fecharLinha())
                .append(fecharLinhaTitulos());
    }

    private void exportarLinhas(List<Produto> produtos, StringBuilder sb) {
        for (Produto produto : produtos) {
            exportarDadosColunas(sb, produto);
        }
    }

    private void exportarDadosColunas(StringBuilder sb, Produto produto) {
        sb.append(abrirLinha());
        for (Coluna coluna : colunas) {
            sb.append(coluna.exportarDado(produto));
        }
        sb.append(fecharLinha());
    }

    public List<Coluna> getColunas() {
        return colunas;
    }

    @Override
    public final void addNewColuna(String titulo, Function<Produto, Object> funcaoValorColuna) {
        Coluna coluna = newColuna(titulo, funcaoValorColuna);
        colunas.add(coluna);
    }
}
