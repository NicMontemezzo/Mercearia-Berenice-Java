/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Scanner;

// Classe base Produto
class Produto {
    private static int contador = 1; // autoincremento
    private int codigo;
    private String descricao;
    private int qtde;

    public Produto(String descricao, int qtde) {
        this.codigo = contador++;
        this.descricao = descricao;
        this.qtde = qtde;
    }

    // Getters e Setters
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

    // Método polimórfico
    public String exibirInfo() {
        return "Código: " + codigo + " | Descrição: " + descricao + " | Qtde: " + qtde;
    }
}

// Classe derivada (herança)
class ProdutoEspecial extends Produto {
    private String categoria;

    public ProdutoEspecial(String descricao, int qtde, String categoria) {
        super(descricao, qtde);
        this.categoria = categoria;
    }

    // Sobrescrevendo método (polimorfismo)
    @Override
    public String exibirInfo() {
        return super.exibirInfo() + " | Categoria: " + categoria;
    }
}

// Classe principal com menu
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> lista = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Cadastrar Produto Especial");
            System.out.println("3 - Listar Produtos");
            System.out.println("4 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtde = sc.nextInt();
                    lista.add(new Produto(desc, qtde));
                    System.out.println("Produto cadastrado!");
                    break;

                case 2:
                    System.out.print("Descrição: ");
                    String descE = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtdeE = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Categoria: ");
                    String cat = sc.nextLine();
                    lista.add(new ProdutoEspecial(descE, qtdeE, cat));
                    System.out.println("Produto especial cadastrado!");
                    break;

                case 3:
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("\n--- LISTA DE PRODUTOS ---");
                        for (Produto p : lista) {
                            System.out.println(p.exibirInfo());
                        }
                    }
                    break;

                case 4:
                    System.out.print("Digite o código do produto para remover: ");
                    int codRemover = sc.nextInt();
                    boolean removido = lista.removeIf(p -> p.getCodigo() == codRemover);
                    if (removido) {
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}

