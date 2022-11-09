import java.util.Locale;
class Application {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    int opcao;
    Controller controller = new Controller();
    System.out.println("Selecione uma opcao: ");
    System.out.println(" 1 | Sou um cliente");
    System.out.println(" 2 | Sou um restaurante");
    System.out.println("-1 | Sair");
    opcao = controller.readIntRange(-1, 2, 0);
    switch(opcao){
      case 1:
        ClienteController cliente = new ClienteController();
        cliente.menuControl();
        break;
      case 2:
        RestauranteController restaurante = new RestauranteController();
        restaurante.menuControl();
        break;
      case 0:
        break;
    }
  }
}