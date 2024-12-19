package com.manoelcampos.exportador;

import java.util.List;
import java.util.function.Function;

/**
 * Define a interface para criação de classes que implementam
 * a exportação de uma lista de produtos para
 * formatos específicos como HTML, CSV, Markdown, etc.
 *
 * @author Manoel Campos da Silva Filho
 */
public interface ExportadorListaProduto {
    /**
     * Retorna o código HTML para abertura de uma tabela.
     * @return
     */
    String abrirTabela();

    /**
     * Retorna o código para fechamento de uma tabela em um formato de dados específico.
     * @return
     */
    String fecharTabela();

    /**
     * Retorna o código para abertura de uma linha da tabela em um formato de dados específico.
     * @return
     */
    String abrirLinha();

    /**
     * Retorna o código para fechamento de uma linha da tabela em um formato de dados específico.
     * @return
     */
    String fecharLinha();


    String abrirLinhaTitulos();

    String fecharLinhaTitulos();

    String exportar(List<Produto> produtos);

    static ExportadorListaProduto newInstance() {
        return newInstance("html");
    }

    static ExportadorListaProduto newInstance(String extensaoArqExportacao){
        /*Esta forma de escrever um switch é chamada de "Switch Expression",
        * onde podemos fazer o switch retornar um valor e armazenar numa variável.
        * Tal recurso foi introduzido definitivamente no JDK 14. */
        return switch (extensaoArqExportacao) {
            case "html" -> new ExportadorListaHtml();
            case "md" -> new ExportadorListaMarkdown();
            default -> throw new UnsupportedOperationException("Formato de arquivo não suportado: " + extensaoArqExportacao);
        };
    }

    Coluna newColuna(String titulo, Function<Produto, Object> funcaoValorColuna);

    void addColuna(Coluna coluna);

    Coluna addNewColuna(String titulo, Function<Produto, Object> funcaoValorColuna);
}
