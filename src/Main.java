import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Produtos disponíveis
        Produto[] produtos = {
                new Televisao(),
                new Radio(),
                new Videogame(),
                new Tablet(),
                new Celular()
        };

        // Carrinho
        ArrayList<Produto> carrinho = new ArrayList<>();

        int opcao;

        System.out.println("=== BEM-VINDO À LOJA ===");

        do {

            System.out.println("\nEscolha um produto:");

            for (int i = 0; i < produtos.length; i++) {

                System.out.println(
                        (i + 1) + " - "
                                + produtos[i].getNome()
                                + " | R$ "
                                + produtos[i].getPreco()
                );
            }

            System.out.println("0 - Finalizar compra");
            System.out.println("\nDigite o número do produto:");

            // Tratando entrada inválida
            if (!scanner.hasNextInt()) {

                System.out.println("Digite apenas números!");
                scanner.next();
                continue;
            }


            opcao = scanner.nextInt();


            // Finalizar
            if (opcao == 0) {
                break;
            }

            // Produto inválido
            if (opcao < 1 || opcao > produtos.length) {

                System.out.println("Produto inválido!");
                continue;
            }

            System.out.println("Quantidade:");

            if (!scanner.hasNextInt()) {

                System.out.println("Quantidade inválida!");
                scanner.next();
                continue;
            }

            int quantidade = scanner.nextInt();

            // Adicionando ao carrinho
            for (int i = 0; i < quantidade; i++) {

                carrinho.add(produtos[opcao - 1]);
            }

            System.out.println("Produto adicionado!");

        } while (true);

        // Finalizando compra
        System.out.println("\n=== RESUMO DA COMPRA ===");

        double total = 0;

        Produto[] listaProdutos = produtos;

        for (Produto produto : listaProdutos) {

            int quantidade = 0;

            for (Produto item : carrinho) {

                if (item.getNome().equals(produto.getNome())) {
                    quantidade++;
                }
            }

            if (quantidade > 0) {

                double subtotal = quantidade * produto.getPreco();

                System.out.println(
                        produto.getNome()
                                + " | Quantidade: "
                                + quantidade
                                + " | Subtotal: R$ "
                                + subtotal
                );

                total += subtotal;
            }
        }

        System.out.println("\nTotal da compra: R$ " + total);

        scanner.close();
    }
}