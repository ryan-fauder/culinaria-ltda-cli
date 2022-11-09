import java.util.NoSuchElementException;
import java.util.Optional;

public class ClienteController extends Controller {
  private ClienteViewer viewer = new ClienteViewer();

  public ClienteController() {
    super();
  }

  public void menuControl() {
    int opcao;
    boolean shouldBreak = false;
    
    while(true) {
      viewer.limpaConsole();
      viewer.menuView();
      opcao = readInteger();
      viewer.limpaConsole();
      switch(opcao)
      {
        case -1:
          shouldBreak = true; break;
        case 1:
          cardapioControl(); break;
        case 2:
          pedirControl(); break;
        case 3:
          pedidosControl(); break;
        case 4:
          restauranteControl(); break;
        default:
          System.out.println("Opcao invalida! Tente novamente");
      }
      if(shouldBreak) break;
    }
  }

  // 1 - Ver cardapio 
  public void cardapioControl() {
    viewer.cardapioView(pratoDao.getList());
    readIntRange(-1, -1);
  }
  
  // 2 - Fazer pedido 
  public void pedirControl() {
    try {
      int opcao;
      Pedido pedido = new Pedido();
      Optional<Prato> optional;
      Prato prato;

      viewer.pedirView(pratoDao.getList());
      while (true) {

        boolean shouldBreak = false;
        opcao = readIntRange(-1, pratoDao.getList().size());

        switch(opcao){
          case -1:
            return;
          case 0:
            shouldBreak = true;
            break;
          default:
            opcao--;
          
            optional = pratoDao.get(opcao);
            prato = optional.orElseThrow();
  
            pedido.addPrato(prato);
            viewer.avisoAcaoPratoView(prato, "adicionado");
        }
        if(shouldBreak) break;
      }

      if(pedido.getValorTotal() == 0) return;
      
      pedirConfirmacaoControl(pedido);
    } 
    catch(NoSuchElementException nsee){
      System.out.println("Prato nao existe");
    }
    catch (Exception exception) {
      System.out.println("Um erro ocorreu");
    }
  }
  
  // 2.1 - Confirmar pedido feito
  public void pedirConfirmacaoControl(Pedido pedido){
    int opcao;
    
    viewer.confirmarPedido(pedido);
    
    opcao = readIntRange(-1, 0);
    switch(opcao){
      case -1:
        return;
      case 0:
        pedidoDao.save(pedido);
        break;
      default:
        System.out.println("Um erro ocorreu");
    }
  }
  
  // 3 - Visualizar pedidos
  public void pedidosControl() {
    int opcao;
    viewer.pedidosView(pedidoDao.getList());
    opcao = readIntRange(-1, 0);
    switch(opcao){
      case -1:
        return;
      case 0:
        cancelarPedidosControl();
        break;
      default:
        System.out.println("Um erro ocorreu");
    }
  }

  // 3.1 - Cancelar algum pedido
  public void cancelarPedidosControl(){
    while (true) {
      try{
        Optional<Pedido> optional;
        Pedido pedido;
        int opcao;
        viewer.cancelarPedidos(pedidoDao.getList());
        
        opcao = readIntRange(-1, pedidoDao.getList().size(), 0);
        
        if (opcao == -1) return;
        opcao--;
        
        optional = pedidoDao.get(opcao);
        pedido = optional.orElseThrow();
        
        viewer.cancelarPedido(pedido);
        
        opcao = readIntRange(-1, 0);
        switch(opcao){
          case -1:
            return;
          case 0:
            pedidoDao.delete(pedido);
            viewer.avisoAcaoPedidoView("cancelado");
            break;
          default:
            System.out.println("Um erro ocorreu");
        }
      }
      catch(NoSuchElementException nsee){
        System.out.println("Pedido não existe");
      }
      catch(Exception exception){
        System.out.println("Uma falha ocorreu");
      }
    }
  }
  
  // 4 - Visualizar restaurante
  public void restauranteControl() {
    Restaurante restaurante = new Restaurante();
    viewer.restauranteView(restaurante);
    readIntRange(-1, -1);
  }
}