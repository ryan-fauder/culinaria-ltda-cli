import java.util.ArrayList;

public class RestauranteViewer extends Viewer {

	public void menuView() {
		System.out.println("----------------------------------------");
		System.out.println("|         Menu do Restaurante          |");
		System.out.println("----------------------------------------");
		System.out.println("|  Selecione alguma da opcoes          |");
		System.out.println("|  1 - Visualizar perfil               |");
		System.out.println("|  2 - Cadastrar prato                 |");
		System.out.println("|  3 - Editar prato                    |");
		System.out.println("|  4 - Remover prato                   |");
		System.out.println("|  5 - Visualizar pratos               |");
		System.out.println("|  6 - Consultar pedidos               |");
		System.out.println("|  7 - Alterar estado de um pedido     |");
		System.out.println("| -1 - Sair                            |");
		System.out.println("----------------------------------------");
	}

	public void restauranteView(Restaurante restaurante) {
		System.out.println("----------------------------------------");
		System.out.println("|       Detalhes do Restaurante        |");
		System.out.println("----------------------------------------");
		System.out.println(restaurante.getNome());
		System.out.println("-" + restaurante.getDescricao());
		System.out.println("-" + restaurante.getEndereco());
		System.out.println("CNPJ: " + restaurante.getCnpj());
		System.out.println("\n-1 | Retornar");
	}

	public void pratosView(ArrayList<Prato> pratos) {
		System.out.println("----------------------------------------");
		System.out.println("|          Pratos cadastrados          |");
		System.out.println("----------------------------------------");
		imprimeListaPratos(pratos);
		System.out.println("----------------------------------------");
		System.out.println("-1 | Retornar");
	}

	public void pedidosView(ArrayList<Pedido> pedidos) {
		System.out.println("----------------------------------------");
		System.out.println("|         Pedidos em andamento         |");
		System.out.println("----------------------------------------");
		imprimeListaPedidos(pedidos);
		System.out.println("----------------------------------------");
		System.out.println("-1 | Retornar");
	}

	public void cadastroView() {
		System.out.println("----------------------------------------");
		System.out.println("|           Cadastrar prato            |");
		System.out.println("----------------------------------------");
	}

	public void editarPratoView(ArrayList<Prato> pratos) {
		System.out.println("----------------------------------------");
		System.out.println("|             Editar prato             |");
		System.out.println("----------------------------------------");
		System.out.println("Lista de pratos:\n");
		imprimeListaPratos(pratos);
		System.out.println("\nDigite o indice do prato:");
		System.out.println("-1 | Retornar");
	}

	public void alteracoesView() {
		System.out.println(" 1 - Alterar nome");
		System.out.println(" 2 - Alterar preco");
		System.out.println(" 3 - Alterar descricao");
		System.out.println("-1 - Retornar");
	}

	public void alterarEstadoView(ArrayList<Pedido> pedidos) {
		System.out.println("----------------------------------------");
		System.out.println("|      Alterar estado de um pedido     |");
		System.out.println("----------------------------------------");
		System.out.println("Lista de pedidos:\n");
		imprimeResumoPedidos(pedidos);
		System.out.println("\nDigite o indice do pedido:");
		System.out.println("-1 | Retornar");
	}

	public void estadosView() {
		System.out.println(" 1 - Realizado");
		System.out.println(" 2 - Confirmado");
		System.out.println(" 3 - Encaminhado");
		System.out.println(" 4 - Concluido");
		System.out.println("-1 - Retornar");
	}

	public void removerPratoView(ArrayList<Prato> pratos) {
		System.out.println("----------------------------------------");
		System.out.println("|            Remover prato             |");
		System.out.println("----------------------------------------");
		System.out.println("Lista de pratos:\n");
		imprimeListaPratos(pratos);
		System.out.println("\nDigite o indice do prato:");
		System.out.println("-1 | Retornar");
	}

	public void confirmarRemocaoView(Prato prato) {
		System.out.println("Deseja remover o prato \"" + prato.getNome() + "\" ?");
		System.out.println(" 0 | Confirmar");
		System.out.println("-1 | Cancelar");
	}

}
