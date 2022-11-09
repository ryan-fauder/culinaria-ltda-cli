import java.io.*;
import java.util.UUID;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;

class PedidoDao implements BasicDao<UUID, Pedido> {
  private static PedidoDao instance;
	private BufferedReader reader = null;
	private PrintWriter writer = null;
	private Map<UUID, Pedido> pedidos = new LinkedHashMap<>();
	private ArrayList<Pedido> pedidosList = new ArrayList<>();
  private static String fileName = "data/pedidos.txt";

  private PedidoDao(){
		getAll();
	}

  public static PedidoDao getInstance() {
    return instance == null ? new PedidoDao() : instance;
  }

  @Override
  public Optional<Pedido> get(UUID id) {
    return Optional.ofNullable(this.pedidos.get(id));
  }


  public Optional<Pedido> get(int index) {
    return Optional.ofNullable(this.pedidosList.get(index));
  }

  @Override
  public Map<UUID, Pedido> getAll() {
		if (!this.pedidos.isEmpty()) {
			return this.pedidos;
		}
		try {
			boolean resave = false;
			reader = new BufferedReader(
						new InputStreamReader(
							new FileInputStream(fileName)));

			PratoDao pratoDao = PratoDao.getInstance();

			String auxString;
			while ((auxString = reader.readLine()) != null) {
				// id_pedido; valor_total; status; lista_id_pratos
				String[] tokens = auxString.split(";", 4);
			  String[] ids = tokens[3].split(";");
				Pedido pedido = new Pedido(UUID.fromString(tokens[0]), 0, tokens[2]);
				
				if (tokens[3].isEmpty()){
					resave = true;
					continue;
				}
				
				for (String id : ids) {
					Optional<Prato> optional = pratoDao.get(UUID.fromString(id));
					if(optional.isEmpty()){
						resave = true;
						continue;
					}
					Prato prato = optional.orElseThrow();
					pedido.addPrato(prato);
       	}

				if(pedido.getPratos().isEmpty()) continue;
				
				this.pedidos.put(pedido.getId(), pedido);
			}
			if(resave) saveAll();
			
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
		catch (NoSuchElementException nseException) {
		// Algum prato não existe
			nseException.printStackTrace();
		}
		catch (InvalidStringException isException) {
			// Status inválido (não está dentre os status definidos ou contém ';')
			isException.printStackTrace();
		}
		finally {
			try { if (reader != null) reader.close(); } 
			catch (IOException ioException) { ioException.printStackTrace(); }
		}
		
		return this.pedidos;
  }

  @Override
  public void save(Pedido pedido){
		if (pedidos.containsKey(pedido.getId())) return;

		try {
			writer = new PrintWriter(
				new OutputStreamWriter(
					new FileOutputStream(fileName, true)));
				
			// id_pedido; valor_total; status; lista_id_pratos
			writer.print(pedido.getId().toString() + ";");
			writer.print(String.format("%.2f", pedido.getValorTotal()) + ";");
			writer.print(pedido.getStatus() + ";");
			for (Prato prato : pedido.getPratos()) {
				writer.print(prato.getId().toString() + ";");
			}
     		writer.println();

			pedidos.put(pedido.getId(), pedido);
			setList();
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
		catch (NullPointerException npException) {
			npException.printStackTrace();
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
					new FileOutputStream(fileName)));
				
			// id_pedido; valor_total; status; lista_id_pratos
			for (Pedido pedido : pedidos.values()) {
				
				if (pedido == null)
					throw new NullPointerException();
				if(pedido.getPratos().size() == 0) continue;

				writer.print(pedido.getId().toString() + ";");
			  writer.print(String.format("%.2f", pedido.getValorTotal()) + ";");
		  	writer.print(pedido.getStatus() + ";");
				for (Prato prato : pedido.getPratos()) {
					writer.print(prato.getId().toString() + ";");
				}
        writer.println();
			}
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
		catch (NullPointerException npException) {
			// Objeto "prato" nulo
			npException.printStackTrace();
		}
		finally {
			try { if (writer != null) writer.close(); }
			catch (Exception exception) { exception.printStackTrace(); }
		}
  }

	@Override
	public void delete(Pedido pedido) {
		try {
			this.pedidos.remove(pedido.getId());
			setList();
			saveAll();
		}
		catch (NullPointerException npException) {
			// Objeto "pedido" nulo
			npException.printStackTrace();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

  @Override
  public void update(Pedido pedido) {
	  	try {
			pedidos.replace(pedido.getId(), pedido);
			setList();
			saveAll();
		}
		catch (NullPointerException npException) {
			// Objeto "pedido" nulo
			npException.printStackTrace();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
  }

  public Map<UUID, Pedido> getPedidos() {
		return pedidos;
  }
	
	public ArrayList<Pedido> getList(){
		if (pedidos.isEmpty()){
			getAll();
		}
		if (pedidosList.isEmpty()) {
			setList();
		}
		return pedidosList;
	}

	public void setList(){
		pedidosList = new ArrayList<Pedido>(pedidos.values());
	}

	public void setMap(Map<UUID, Pedido> map){
		this.pedidos = map;
		setList();
	}
}