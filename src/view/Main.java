package view;

import model.Item;
import model.Produto;
import model.Venda;

public class Main {
    public static void main(String[] args) {

        Venda venda = new Venda();
        venda.adicionarProdutos();

        System.out.println("\nRECIBO DA COMPRA");
        for (Item item : venda.getItens()) {
            System.out.println(item.getProduto().getCategoria() + " | "
                    + item.getProduto().getDescricao().toUpperCase() + " (" +
                    (int) item.getQuantidade() + "x) | SUBTOTAL R$" + item.getSubtotal());
        }
        System.out.println("\nTOTAL DA VENDA R$" + venda.getTotal());
    }
}