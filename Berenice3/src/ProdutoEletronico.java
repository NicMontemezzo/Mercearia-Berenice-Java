public class ProdutoEletronico extends Produto {
    private int garantiaMeses;

    public ProdutoEletronico(String descricao, int qtde, int garantiaMeses) {
        super(descricao, qtde);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public String toString() {
        return super.toString() + " | Garantia: " + garantiaMeses + " meses";
    }
}
