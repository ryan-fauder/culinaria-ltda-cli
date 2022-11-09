import java.util.ArrayList;

public class ClienteViewer extends Viewer {

  public void avisoAcaoPratoView(Prato prato, String action){
    System.out.println("O prato " + prato.getNome() + " foi " + action + "!");
  }

  public void avisoAcaoPedidoView(String action){
    System.out.println("O pedido foi " + action + "!");
  }

  public void menuView() {
    System.out.println("-----------------------------------");
    System.out.println("|              Menu               |");
    System.out.println("-----------------------------------");
    System.out.println("| Selecione alguma da opcoes      |");
    System.out.println("|  1 - Ver cardapio               |");
    System.out.println("|  2 - Fazer pedido               |");
    System.out.println("|  3 - Visualizar pedidos         |");
    System.out.println("|  4 - Visualizar restaurante     |");
    System.out.println("| -1 - Sair                       |");
    System.out.println("-----------------------------------");
  }

  public void cardapioView(ArrayList<Prato> pratos) {
    System.out.println("-----------------------------------");
    System.out.println("              Cardapio             ");
    System.out.println("-----------------------------------");
    imprimeListaPratos(pratos);
    System.out.println("-1 | Retornar");
  }

  public void cancelarPedidos(ArrayList<Pedido> pedidos){
    System.out.println("-----------------------------------");
    System.out.println("      Meus pedidos - Cancelar      ");
    System.out.println("-----------------------------------");
    System.out.println("Digite algum dos indices para cancelar o pedido:");
    System.out.println("");
    imprimeResumoPedidos(pedidos);
    System.out.println("");
    System.out.println("-1 | Retornar");
  }

  public void cancelarPedido(Pedido pedido){
    System.out.println("-----------------------------------");
    System.out.println("       Meu pedido - Cancelar       ");
    System.out.println("-----------------------------------");
    imprimePedido(pedido);
    System.out.println(" 0 | Cancelar o pedido");
    System.out.println("-1 | Retornar");
  }

  public void confirmarPedido(Pedido pedido){
    System.out.println("-----------------------------------");
    System.out.println("            Meu pedido             ");
    System.out.println("-----------------------------------");
    imprimeConfirmacaoPedido(pedido);
    System.out.println(" 0 | Confirmar pedido");
    System.out.println("-1 | Cancelar pedido");
  }

  public void pedidosView(ArrayList<Pedido> pedidos) {
    System.out.println("-----------------------------------");
    System.out.println("            Meus pedidos           ");
    System.out.println("-----------------------------------");
    imprimeListaPedidos(pedidos);
    System.out.println("-1 | Retornar");
    System.out.println("Digite 0 para cancelar algum pedido");
  }

  public void pedirView(ArrayList<Prato> pratos){
    System.out.println("-----------------------------------");
    System.out.println("            Meu pedido             ");
    System.out.println("-----------------------------------");
    System.out.println("Digite um dos indices para adicionar o prato ao seu pedido:");
    imprimeListaPratos(pratos);
    System.out.println(" 0 | Finalizar pedido");
    System.out.println("-1 | Retornar");
  }

  public void restauranteView(Restaurante restaurante) {
    System.out.println("-----------------------------------");
    System.out.println("     Sobre o nosso restaurante     ");
    System.out.println("-----------------------------------");
    imprimeRestaurante(restaurante);
    System.out.println("Venha nos visitar!");
    System.out.println("-1 | Retornar");
  }
}
