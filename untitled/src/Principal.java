import com.kadukitesesi.vendas.Cliente;
import com.kadukitesesi.vendas.Pedido;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Principal {

    private final static NumberFormat FORMATADOR_MOEDA = NumberFormat.getCurrencyInstance(
            new Locale("pt", "BR"));

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João");
        Pedido pedido = new Pedido(cliente);

        Pedido.Item item1 = pedido.adicionarItem("iPhone 14", 3, new BigDecimal("12000"));
        Pedido.Item item2 = pedido.adicionarItem("Apple Watch", 3, new BigDecimal("5900"));

        imprimirResumo(pedido);

        System.out.println("---");

        item1.setQuantidade(20);
        imprimirResumo(pedido);

        pedido.emitir();
    }

    private static void imprimirResumo(Pedido pedido) {
        for (Pedido.Item item : pedido.getItens()) {
            System.out.printf("%dx %s (%s) = %s%n",
                    item.getQuantidade(), item.getDescricao(),
                    FORMATADOR_MOEDA.format(item.getValorUnitario()),
                    FORMATADOR_MOEDA.format(item.getValorTotal()));
        }

        System.out.printf("Total: %s%n", FORMATADOR_MOEDA.format(pedido.getValorTotal()));
    }

}