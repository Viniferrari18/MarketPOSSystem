package simuladorMaquininha;

public class Main {
    public static void main(String[] args) {
        Mercado m = new Mercado();

        m.adicionarProduto(new Produto("Arroz", 15.0d));
        m.adicionarProduto(new Produto("Feijão", 9.80d));
        m.adicionarProduto(new Produto("Carne", 39.90d));
        m.adicionarProduto(new Produto("Alface", 11.0d));
        m.adicionarProduto(new Produto("Pão de alho", 17.90d));
        m.listarProdutos();

        m.adicionarProdutoCarrinho(2);
        m.adicionarProdutoCarrinho(0);
        m.adicionarProdutoCarrinho(1);
        m.adicionarProdutoCarrinho(3);
        m.adicionarProdutoCarrinho(4);
        m.mostrarCarrinho();

        Maquininha maquininha = new Maquininha();

        maquininha.ligar();
        maquininha.cartaoInserido();
        maquininha.pagamento(m.getCarrinho());

    }
}
