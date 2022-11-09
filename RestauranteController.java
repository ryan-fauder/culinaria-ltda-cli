import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;

public class RestauranteController extends Controller {
	private RestauranteViewer viewer = new RestauranteViewer();

	public RestauranteController() {
		super();
	}

	public void menuControl() {
		try {
			int opcao;
			boolean shouldBreak = false;

			while (true) {
				viewer.limpaConsole();
				viewer.menuView();
				opcao = readInteger();
				viewer.limpaConsole();

				switch (opcao) {
					case -1: // Sair
						shouldBreak = true;
						break;
					case 1: // Visualizar perfil
						restauranteControl();
						break;
					case 2: // Cadastrar prato
						cadastrarControl();
						break;
					case 3: // Editar prato
						editarControl();
						break;
					case 4: // Remover prato
						removerControl();
						break;
					case 5: // Visualizar pratos
						pratosControl();
						break;
					case 6: // Consultar pedidos
						pedidosControl();
						break;
					case 7: // Alterar estado de um pedido
						alterarEstadoControl();
						break;
					default:
						System.out.println("Opcao invalida! Tente novamente");
				}
				if (shouldBreak) break;
			}
		} catch (InputMismatchException imException) {
			imException.printStackTrace();
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
	}

	// 1 - Visualizar perfil
	public void restauranteControl() {
		viewer.restauranteView(new Restaurante());
		readIntRange(-1, -1);
	}

	// 2 - Cadastrar prato
	public void cadastrarControl() {
		try {
			Prato novoPrato;
			String nome, descricao;
			Double preco;

			viewer.cadastroView();
			System.out.print("Nome do prato: ");
			nome = input.nextLine();

			System.out.print("Preco: ");
			preco = readDoubleRange(0);

			System.out.print("Descricao: ");
			descricao = input.nextLine();

			novoPrato = new Prato(nome, preco, descricao);
			pratoDao.save(novoPrato);
		} catch (InvalidPriceException ipException) {
			// Preço inválido (<= 0)
			ipException.printStackTrace();
		} catch (InvalidStringException isException) {
			// Alguma String contém ';'
			isException.printStackTrace();
		}

	}

	// 3 - Editar prato
	public void editarControl() {
		int opcao;
		try {
			ArrayList<Prato> listaPratos = pratoDao.getList();
			viewer.editarPratoView(listaPratos);

			opcao = readIntRange(-1, listaPratos.size(), 0);
			if (opcao == -1) return;

			Prato prato = listaPratos.get(opcao - 1);

			System.out.print("\n" + opcao + " | ");
			while (true) {
				viewer.imprimePrato(prato);
				viewer.alteracoesView();
				opcao = readIntRange(-1, 3, 0);
				switch (opcao) {
					case -1:
						return;
					case 1:
						System.out.print("\nNovo nome: ");
						prato.setNome(input.nextLine());
						break;
					case 2:
						System.out.print("\nNovo preco: ");
						prato.setPreco(readDoubleRange(0));
						break;
					case 3:
						System.out.print("\nNova descricao: ");
						prato.setDescricao(input.nextLine());
						break;
				}
				pratoDao.update(prato);
				pedidoDao.setMap(new LinkedHashMap<>());
				pedidoDao.getAll();
				pedidoDao.setList();
				System.out.println("\nAlteracao realizada com sucesso!\n");
			}
		} catch (InvalidPriceException ipException) {
			ipException.printStackTrace();
		} catch (InvalidStringException isException) {
			isException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	// 4 - Remover prato
	public void removerControl() {
		try {
			ArrayList<Prato> listaPratos = pratoDao.getList();
			viewer.removerPratoView(listaPratos);

			int opcao = readIntRange(-1, listaPratos.size(), 0);
			if (opcao == -1) return;

			Prato prato = listaPratos.get(opcao - 1);

			viewer.confirmarRemocaoView(prato);
			opcao = readIntRange(-1, 0);
			if (opcao == -1) {
				System.out.println("\nOperacao cancelada\n");
				return;
			}
			pratoDao.delete(prato);
			pedidoDao.setMap(new LinkedHashMap<>());
			pedidoDao.getAll();
			pedidoDao.setList();
			System.out.println("\nPrato removido com sucesso!\n");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	// 5 - Visualizar pratos
	public void pratosControl() {
		viewer.pratosView(pratoDao.getList());
		readIntRange(-1, -1);
	}

	// 6 - Consultar pedidos
	public void pedidosControl() {
		viewer.pedidosView(pedidoDao.getList());
		readIntRange(-1, -1);
	}

	// 7 - Alterar estado de um pedido
	public void alterarEstadoControl() {
		try {
			ArrayList<Pedido> listaPedidos = pedidoDao.getList();
			viewer.alterarEstadoView(listaPedidos);

			int opcao = readIntRange(-1, listaPedidos.size(), 0);
			if (opcao == -1) return;

			Pedido pedido = listaPedidos.get(opcao - 1);

			System.out.print("\n" + opcao + " | ");
			viewer.imprimeResumoPedido(pedido);
			System.out.print("\nInforme o novo estado:\n");
			viewer.estadosView();

			int indice = readIntRange(-1, 4, 0);

			if (indice == -1) {
				System.out.println("\nOperacao cancelada\n");
				return;
			}

			String[] estados = {"Realizado", "Confirmado", "Encaminhado", "Concluido"};
			pedido.setStatus(estados[indice - 1]);
			pedidoDao.update(pedido);
			System.out.println("\nEstado alterado com sucesso!\n");
		} catch (InvalidStringException isException) {
			isException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}