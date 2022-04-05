import java.util.Map;
import java.util.UUID;

public class ClienteViewer {
  
  public static void menu( ){
    System.out.println("----------------------------------");
    System.out.println("Menu");
    System.out.println("----------------------------------");
    System.out.println("| Selecione alguma da opcoes");    
    System.out.println("| 1 - Visualizar Restaurante");
    System.out.println("| 2 - Ver Cardapio");
    System.out.println("| 3 - Fazer pedido");
    System.out.println("| 4 - Visualizar Pedidos");
    System.out.println("----------------------------------");
                 
  }

  public static void verCardapio(Map<UUID, Prato> pratos){
    int contador = 1;
    System.out.println("----------------------------------");
    System.out.println("Cardapio");
    System.out.println("----------------------------------");
    for (Prato prato : pratos.values()) {
      System.out.print(contador + " | ");
      System.out.print(prato.getNome() + " - ");
      System.out.printf("R$ %.2f\n", prato.getPreco());
      System.out.println("-> " + prato.getDescricao() + "\n");
      contador++;
    }
    System.out.println("----------------------------------");
  }

  public static void visualizarPedidos(Map<UUID, Pedido> pedidos){
    int contador = 1;
    System.out.println("----------------------------------");
    System.out.println("Meus pedidos");
    System.out.println("----------------------------------");
    for (Pedido pedido : pedidos.values()) {
      System.out.print("Contador" + contador + " | ");
      // System.out.printf("R$ %.2f\n", prato.getPreco());
      // System.out.println("-> " + prato.getDescricao() + "\n");
      contador++;
    }
    System.out.println("----------------------------------");
  }

  public static void visualizarRestaurante(Restaurante restaurante){
    System.out.println("Sobre o restaurante");
    System.out.println();
  }
}

/*
  ajuda
  fazerPedido
  visualizarRestaurante
  visualizarPedidos
  verCardapio
*/

