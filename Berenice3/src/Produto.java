public class Produto {
    private static int proximoCodigo = 1;

    private int codigo;
    private String descricao;
    private int qtde;

    public Produto(String descricao, int qtde) {
        this.codigo = proximoCodigo++;
        this.descricao = descricao;
        this.qtde = qtde;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               " | Descrição: " + descricao +
               " | Quantidade: " + qtde;
    }
}
