import java.io.*;
import java.util.UUID;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Optional;

class PedidoDao implements BasicDao<UUID, Pedido> {
  private static PedidoDao instance;
	private BufferedReader reader = null;
	private PrintWriter writer = null;
	private Map<UUID, Pedido> pedidos = new LinkedHashMap<>();

  private PedidoDao(){
  }

  public static PedidoDao getInstance() {
    return instance == null ? new PedidoDao() : instance;
  }

  @Override
  public Optional<Pedido> get(UUID id) {
    return Optional.ofNullable(this.pedidos.get(id));
  }

  @Override
  public Map<UUID, Pedido> getAll() {
		if (!this.pedidos.isEmpty()) {
			return this.pedidos;
		}

		try {
			reader = new BufferedReader(
						new InputStreamReader(
							new FileInputStream("data/pedidos.txt")));

			PratoDao pratoDao = PratoDao.getInstance();
			pratoDao.getAll();

			String auxString;
			while ((auxString = reader.readLine()) != null) {
				// id_pedido; valor_total; status; lista_id_pratos
				String[] tokens = auxString.split(";", 4);
			  String[] ids = tokens[4].split(";");
  
				Pedido pedido = new Pedido(UUID.fromString(tokens[0]), Double.parseDouble(tokens[1]), tokens[2]);
        
				for (String id : ids) {	
					Prato prato = pratoDao.get(UUID.fromString(id)).get();
				  pedido.addPrato(prato);
        }

				this.pedidos.put(pedido.getId(), pedido);
			}
			
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
		finally {
			try { if (reader != null) reader.close(); } 
			catch (IOException ioException) { ioException.printStackTrace(); }
		}
		
		return this.pedidos;
  }

  @Override
  public void save(Pedido pedido) {
		if (pedido == null) return;
		if (pedidos.containsKey(pedido.getId())) return;

		try {
			writer = new PrintWriter(
				new OutputStreamWriter(
					new FileOutputStream("data/pedidos.txt", true)));
				
			// id_pedido; valor_total; status; lista_id_pratos
			writer.print(pedido.getId().toString() + ";");
			writer.print(String.format("%.2f", pedido.getValorTotal()) + ";");
			writer.print(pedido.getStatus() + ";");
      for (Prato prato : pedido.getPratos()) {
        writer.print(prato.getId().toString() + ";");
      }
      writer.println(); // verificar

			pedidos.put(pedido.getId(), pedido);
		}
		catch (IOException ioException) {
			ioException.printStackTrace();

		}
		finally {
			try { if (writer != null) writer.close(); }
			catch (Exception exception) { exception.printStackTrace(); }
		}
    
  }

  @Override
  public void saveAll() {
		try {
			writer = new PrintWriter(
				new OutputStreamWriter(
					new FileOutputStream("data/pedidos.txt")));
				
			// id_pedido; valor_total; status; lista_id_pratos
			for (Pedido pedido : pedidos.values()) {
				writer.print(pedido.getId().toString() + ";");
			  writer.print(String.format("%.2f", pedido.getValorTotal()) + ";");
		  	writer.print(pedido.getStatus() + ";");
				for (Prato prato : pedido.getPratos()) {
          writer.print(prato.getId().toString() + ";");
        }
        writer.println(); // verificar
			}
		}
		catch (IOException ioException) {
			ioException.printStackTrace();

		}
		finally {
			try { if (writer != null) writer.close(); }
			catch (Exception exception) { exception.printStackTrace(); }
		}
  }

	@Override
	public void delete(Pedido pedido) {
		if (pedido == null) return;
		this.pedidos.remove(pedido.getId());
		saveAll();
	}

  @Override
  public void update(Pedido pedido) {
    if (pedido == null) return;
		this.pedidos.replace(pedido.getId(), pedido);
		saveAll();
  }

  public Map<UUID, Pedido> getPedidos() {
		  return pedidos;
  }
	
}