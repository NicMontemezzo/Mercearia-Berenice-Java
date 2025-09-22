import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciadorProdutos {
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrar(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public void remover(int codigo) {
        Iterator<Produto> it = produtos.iterator();
        while (it.hasNext()) {
            Produto p = it.next();
            if (p.getCodigo() == codigo) {
                it.remove();
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto com código " + codigo + " não encontrado.");
    }
}
