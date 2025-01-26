import com.manoelcampos.exportador.Coluna;
import com.manoelcampos.exportador.ExportadorListaProduto;
import com.manoelcampos.exportador.Produto;

import java.util.List;

public class Principal {

    private static final List<Produto> PRODUTOS = List.of(
            new Produto("TV", "LG", "132-A", 120),
            new Produto("Notebook", "Asus", "New age", 341),
            new Produto("Smartphone", "Samsung", "Galaxy S10", 214)
    );

    public static void main(String[] args) {
        var principal = new Principal();
        principal.exportarProdutos();
    }

    private void exportarProdutos() {
        ExportadorListaProduto exportadorPadrao = ExportadorListaProduto.newInstance();

        exportadorPadrao.addNewColuna("Estoque multiplicado", this::multiplicaEstoque);

        System.out.println("Lista de Produtos em HTML----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar(PRODUTOS));

        exportadorPadrao = ExportadorListaProduto.newInstance("md");
        System.out.println("Lista de Produtos em MarkDown----------------------------------------------------------\n");
        System.out.println(exportadorPadrao.exportar(PRODUTOS));

    }

    private Double multiplicaEstoque(Produto produto) {
        return produto.getEstoque() * 0.9;
    }


}
