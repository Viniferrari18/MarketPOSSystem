package simuladorMaquininha;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private List<Produto> estoque = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        estoque.add(p);
    }

    public void listarProdutos() {
        System.out.println("\n🛒 Produtos disponíveis:");
        System.out.println("──────────────────────────────");
        for (int i = 0; i < estoque.size(); i++) {
            Produto p = estoque.get(i);
            System.out.println(p.getNome() + " ......... " + " R$ " + p.getPreco());
        }
        System.out.println("──────────────────────────────");
    }

    private List<Produto> carrinho = new ArrayList<>();

    public void adicionarProdutoCarrinho(int indice) {
        if (indice >= 0 && indice < estoque.size()) {
            Produto p = estoque.get(indice);
            carrinho.add(p);
        } else {
            System.out.println("Produto invalido");
        }
    }

    public void mostrarCarrinho() {
        System.out.println("\n🧺 Seu Carrinho:");
        System.out.println("──────────────────────────────");
        double total = 0;
        for (Produto p : carrinho) {
            System.out.printf("• %-13s R$ %.2f\n", p.getNome(), p.getPreco());
            total += p.getPreco();
        }
        System.out.printf("------------------------\nTotal: R$ %.2f\n", total);
    }

    public void limparCarrinho() {
        carrinho.clear();
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }
}