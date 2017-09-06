package br.com.renan;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio {

    public static void main(String[] args) {
        int i = 0;
        ArrayList catalogo = criarCatalogo();
        menu(catalogo, i);
    }

    public static void menu(ArrayList catalogo, int i) {
        Scanner console = new Scanner(System.in);
        ArrayList<Produto> comanda = new ArrayList<Produto>();
        boolean sair = false;
        do {
            System.out.println("Selecione uma opção: \n");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Mostrar Catálogo");
            System.out.println("3 - Registrar Produto na Comanda");
            System.out.println("4 - Exibir Comanda");
            System.out.println("5 - Sair\n");
            System.out.print("Opção: ");
            int opcao = console.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarProduto(catalogo);
                    break;
                case 2:
                    exibirCatalogo(catalogo);
                    break;
                case 3:
                    comanda = registrarProduto(catalogo,i);
                    break;
                case 4:
                    exibirComanda(comanda);
                    break;
                case 5:
                    sair = true;
                    System.out.println("\n** Obrigado por usar! **");
            }
        } while (!sair);

    }

    public static ArrayList criarCatalogo() {
        ArrayList<Produto> catalogo = new ArrayList<Produto>();
        return catalogo;
    }

    public static void cadastrarProduto(ArrayList catalogo) {
        Scanner console = new Scanner(System.in);

        Produto prod = new Produto();
        String codigo;
        String descricao;
        double preco;

        System.out.println("\n======================================");
        System.out.println("\n=== CADASTRAR PRODUTO NOVO ===");
        System.out.println("\nInsira os dados do novo produto: \n");
        System.out.print("Código: ");
        codigo = console.next();
        prod.setCodigo(codigo);
        System.out.print("Descrição: ");
        descricao = console.next();
        prod.setDescricao(descricao);
        System.out.print("Preço: ");
        preco = console.nextDouble();
        prod.setPreco(preco);

        catalogo.add(prod);

        System.out.println("\n===========================");
        System.out.println("** Produto cadastrado! **");
        System.out.println("===========================\n");

    }

    public static void exibirCatalogo(ArrayList<Produto> catalogo) {
        System.out.println("\n=== CATÁLOGO DE PRODUTOS ===\n");
        System.out.println("=================================");
        for (Produto prod : catalogo) {
            System.out.println("Código: " + prod.getCodigo());
            System.out.println("Descrição: " + prod.getDescricao());
            System.out.println("Preço: " + prod.getPreco());
            System.out.println("=================================");
        }
        System.out.println("");
    }

    public static ArrayList registrarProduto(ArrayList<Produto> catalogo, int i) {
        Scanner console = new Scanner(System.in);
        ArrayList<Produto> comanda = new ArrayList<Produto>();
        System.out.println("Digite o código do produto desejado: ");
        String codigo = console.next();
        for (Produto prod : catalogo) {
            if (codigo.equals(prod.getCodigo())) {
                i++;
                System.out.println("asdasda");
                comanda.add(catalogo.get(i));
                System.out.println(i);
            
            }
        }
        return comanda;
    }

    public static void exibirComanda(ArrayList<Produto> comanda) {
        for (Produto coma : comanda) {
            System.out.println("Codigo: " + coma.getCodigo());
            System.out.println("Descrição: " + coma.getDescricao());
            System.out.println("Preço: " + coma.getPreco());
        }
    }

}
