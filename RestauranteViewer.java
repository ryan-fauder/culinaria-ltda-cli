import java.util.Map;
import java.util.UUID;

public class RestauranteViewer {
  
        public static void menu( ){
    System.out.println("----------------------------------");
    System.out.println("Menu do Restaurante");
    System.out.println("----------------------------------");
    System.out.println("| Selecione alguma da opcoes");    
    System.out.println("| 1 - Editar Perfil");
    System.out.println("| 2 - Cadastrar Prato");
    System.out.println("| 3 - Editar Pratos");
    System.out.println("| 4 - Visualizar Pratos");
    System.out.println("| 5 - Consultar Pedidos");
    System.out.println("| 6 - Alterar Estado do Pedido");
    System.out.println("----------------------------------");
                 
  }

    public static void visualizarPratos(Map<UUID, Prato> pratos){
        System.out.println("----------------------------------");
        System.out.println("Pratos cadastrados :");
        System.out.println("----------------------------------");
         Prato prato = new Prato();
        System.out.print(prato.getNome() + " : ");
        System.out.printf("R$ %.2f\n", prato.getPreco());
        System.out.println("- " + prato.getDescricao() + "\n");     
    }

    public static void cosultarPedidos(Map<UUID, Pedido> pedidos){
         System.out.println("----------------------------------");   
         System.out.println("Pedidos em andamento:");
         System.out.println("----------------------------------");
        Pedido pedido = new Pedido();
         System.out.println(pedido.getId());

    }



    
}
/*
  cadastrarPrato
  consultarPedidos
  visualizarPratos
  editarPrato
  alterarEstadoDoPedido
  editarPerfil
*/