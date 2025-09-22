import java.time.LocalDate;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar produto eletrônico");
            System.out.println("2 - Cadastrar produto alimentício");
            System.out.println("3 - Listar produtos");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtde = Integer.parseInt(sc.nextLine());
                    System.out.print("Garantia (em meses): ");
                    int garantia = Integer.parseInt(sc.nextLine());

                    gerenciador.cadastrar(new ProdutoEletronico(desc, qtde, garantia));
                }
                case 2 -> {
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtde = Integer.parseInt(sc.nextLine());
                    System.out.print("Validade (AAAA-MM-DD): ");
                    LocalDate validade = LocalDate.parse(sc.nextLine());

                    gerenciador.cadastrar(new ProdutoAlimenticio(desc, qtde, validade));
                }
                case 3 -> gerenciador.listar();
                case 4 -> {
                    System.out.print("Digite o código do produto a remover: ");
                    int cod = Integer.parseInt(sc.nextLine());
                    gerenciador.remover(cod);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
