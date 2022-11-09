import java.util.ArrayList;

public abstract class Viewer {

  public void imprimePrato(Prato prato){
    System.out.print(prato.getNome() + " - ");
    System.out.printf("R$ %.2f\n", prato.getPreco());
    System.out.println("-> " + prato.getDescricao() + "\n");
  }

  public void imprimeConfirmacaoPedido(Pedido pedido){
    System.out.printf("Preco total: R$ %.2f\n", pedido.getValorTotal());
    System.out.println("Pratos:");
    imprimeListaPratos((ArrayList<Prato>) pedido.getPratos());
    System.out.println("");
  }

  public void imprimePedido(Pedido pedido){
    System.out.printf("Preco total: R$ %.2f\n", pedido.getValorTotal());
    System.out.println("Estado: " + pedido.getStatus());
    System.out.println("Pratos:");
    imprimeListaPratos((ArrayList<Prato>) pedido.getPratos());
    System.out.println("");
  }

  public void imprimeResumoPedido(Pedido pedido){
    System.out.printf("Preco total: R$ %.2f", pedido.getValorTotal());
    System.out.print(" | " + pedido.getStatus());
  }

  public void imprimeListaPratos(ArrayList<Prato> pratos){
    int contador = 1;
    for (Prato prato : pratos) {
      System.out.print((contador++) + " | ");
      imprimePrato(prato);
    }
  }

  public void imprimeListaPedidos(ArrayList<Pedido> pedidos){
    int contadorPedido = 1;
    for (Pedido pedido : pedidos) {
      System.out.print("Pedido " + contadorPedido++ + " | ");
      imprimePedido(pedido);
    }
  }
  
  public void imprimeResumoPedidos(ArrayList<Pedido> pedidos){
    int contadorPedido = 1;
    for (Pedido pedido : pedidos) {
      System.out.print(contadorPedido++ + " | ");
      imprimeResumoPedido(pedido);
      System.out.println("");
    }
  }

  public void imprimeRestaurante(Restaurante restaurante){
    System.out.println(restaurante.getNome());
    System.out.println("CNPJ: " + restaurante.getCnpj());
    System.out.println("- " + restaurante.getDescricao());
    System.out.println("Endereco:");
    System.out.println(restaurante.getEndereco());
  }

  public void limpaConsole(){
    try
    {
      System.out.print("\033[H\033[2J");  
      System.out.flush();
    }
    catch (final Exception e)
    {
      e.printStackTrace();
    }
  }
}