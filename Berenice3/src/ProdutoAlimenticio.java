import java.time.LocalDate;

public class ProdutoAlimenticio extends Produto {
    private LocalDate validade;

    public ProdutoAlimenticio(String descricao, int qtde, LocalDate validade) {
        super(descricao, qtde);
        this.validade = validade;
    }

    @Override
    public String toString() {
        return super.toString() + " | Validade: " + validade;
    }
}
