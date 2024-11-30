package model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Venda {

    private Item[] itens;
    private LocalDateTime dataHora;
    private int quantidadeItens;

    public Venda() {
        itens = new Item[3];
        dataHora = LocalDateTime.now();
        quantidadeItens = 0;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < quantidadeItens; i++) {
            total += itens[i].getSubtotal();
        }
        return total;
    }

    public boolean adicionarItem(Item item) {
        if (quantidadeItens == itens.length) {
            itens = Arrays.copyOf(itens, itens.length + 3);
        }
        itens[quantidadeItens++] = item;
        return true;
    }

    public Item[] getItens() {
        return Arrays.copyOf(itens, quantidadeItens);
    }

    public Produto lerProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe a descrição do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe sua Categoria | 1-ALIMENTICIO | 2-HIGIENE | 3-LIMPEZA | 4-HORTIFRUTI | 5-PADARIA |: ");
        Categoria categoria = Categoria.values()[scanner.nextInt() - 1];

        return new Produto(codigo, descricao, preco, categoria);
    }

    public void adicionarProduto(Produto produto, double quantidade) {
        Item item = new Item(quantidadeItens + 1, produto, quantidade);
        adicionarItem(item);
    }

    public void adicionarProdutos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos produtos você deseja adicionar? ");
        int numeroProdutos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numeroProdutos; i++) {
            System.out.println("\nAdicionando produto " + (i + 1) + ":");
            Produto produto = lerProduto();

            System.out.print("Informe a quantidade do produto:");
            double quantidade = scanner.nextDouble();
            scanner.nextLine();

            adicionarProduto(produto, quantidade);
        }

        System.out.println("\nProdutos adicionados!");
    }
}
