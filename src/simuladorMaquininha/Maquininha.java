package simuladorMaquininha;

import java.util.List;

public class Maquininha {
    private boolean status;
    private boolean cartaoInserido;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isCartaoInserido() {
        return cartaoInserido;
    }

    public void setCartaoInserido(boolean cartaoInserido) {
        this.cartaoInserido = cartaoInserido;
    }

    public void ligar() {
        this.status = true;
    }

    public void desligar() {
        this.status = false;
    }

    public void cartaoInserido() {
        if (!this.status) {
            System.out.println("Ligue a maquininha primeiro");
            this.cartaoInserido = false;
        } else {
            System.out.println("\n✅ Cartão inserido com sucesso");
            this.cartaoInserido = true;
        }
    }

    public void cartaoRemovido() {
        this.cartaoInserido = false;
    }

    public void pagamento(List<Produto> carrinho) {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio. Adicione produtos antes de prosseguir com o pagamento.");
        } else if (!status) {
            System.out.println("A maquininha está desligada. Ligue-a primeiro!");
        } else if (!cartaoInserido) {
            System.out.println("Por favor, insira o cartão para continuar.");
        } else {
            double total = 0;
            for (Produto p : carrinho) {
                total += p.getPreco();
            }

            System.out.println("✅ Iniciando o pagamento...");

            // Simulação de sucesso ou falha no pagamento
            boolean pagamentoSucesso = Math.random() > 0.1; // 90% de chance de sucesso

            if (pagamentoSucesso) {
                System.out.println("✅ Pagamento realizado com sucesso!");
                fichaDaMaquininha("Mercado da Esquina", total, carrinho, true);
            } else {
                System.out.println("❌ Pagamento falhou. Tente novamente.");
                fichaDaMaquininha("Mercado da Esquina", total, carrinho, false);
            }
        }
    }

    public void fichaDaMaquininha(String nomeMercado, double totalCompra, List<Produto> carrinho, boolean sucesso) {
        System.out.println("\n===== FICHA DA MAQUININHA =====");
        System.out.println(" Mercado : " + nomeMercado);
        System.out.println("🔌 Status: " + (this.status ? "Ligada" : "Desligada"));
        System.out.println("🛍️ Itens no carrinho: " + carrinho.size());
        System.out.printf("🛒 Valor total da compra: R$ %.2f\n", totalCompra);
        System.out.println("💳 Status do Pagamento: " + (sucesso ? "Sucesso" : "Falha"));
        System.out.println("===============================");
    }
}
