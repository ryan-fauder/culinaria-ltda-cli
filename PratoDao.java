import java.io.*;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.UUID;

class PratoDao implements BasicDao<UUID, Prato> {
	private static PratoDao instance;
	private BufferedReader reader = null;
	private PrintWriter writer = null;
	private Map<UUID, Prato> pratos = new LinkedHashMap<>();

	private PratoDao(){
	}
	
	public static PratoDao getInstance() {
		// if (instance == null)
		// 	instance = new PratoDao();
		// return instance;
		return instance == null ? new PratoDao() : instance;
	}
	
	@Override
	public Optional<Prato> get(UUID id) {
		return Optional.ofNullable(this.pratos.get(id));
	}
	
	@Override
	public Map<UUID, Prato> getAll() {
		
		if (!this.pratos.isEmpty()) {
			return this.pratos;
		}
		
		try {
			reader = new BufferedReader(
						new InputStreamReader(
							new FileInputStream("data/pratos.txt")));

			String auxString;
			
			while ((auxString = reader.readLine()) != null) {
				// id; nome; preço; descrição
				String[] tokens = auxString.split(";", 4);
				
				this.pratos.put(UUID.fromString(tokens[0]), new Prato(UUID.fromString(tokens[0]), 
							tokens[1], Double.parseDouble(tokens[2]), tokens[3]));
			}
			
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
		finally {
			try { if (reader != null) reader.close(); } 
			catch (IOException ioException) { ioException.printStackTrace(); }
		}
		
		return this.pratos;
	}
	
	@Override
	public void save(Prato prato) {
		if ( prato == null ) return;
		if ( pratos.containsKey(prato.getId()) ) return;

		try {
			writer = new PrintWriter(
				new OutputStreamWriter(
					new FileOutputStream("data/pratos.txt", true)));
				
			// id; nome; preço; descrição
			writer.print(prato.getId().toString() + ";");
			writer.print(prato.getNome() + ";");
			writer.print(String.format("%.2f", prato.getPreco()) + ";");
			writer.println(prato.getDescricao());

			pratos.put(prato.getId(), prato);
		}
		catch (IOException ioException) {
			ioException.printStackTrace();

		}
		finally {
			try { if (writer != null) writer.close(); }
			catch (Exception exception) { exception.printStackTrace(); }
		}
		
	} 
	
	public void saveAll() {
		try {
			writer = new PrintWriter(
				new OutputStreamWriter(
					new FileOutputStream("data/pratos.txt")));
				
			// id; nome; preço; descrição
			for (Prato prato : pratos.values()) {
				writer.print(prato.getId().toString() + ";");
				writer.print(prato.getNome() + ";");
				writer.print(String.format("%.2f", prato.getPreco()) + ";");
				writer.println(prato.getDescricao());
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
	public void delete(Prato prato) {
		if (prato == null) return;
		pratos.remove(prato.getId());
		saveAll();
	}
	
	@Override
	public void update(Prato prato) {
		if (prato == null) return;
		this.pratos.replace(prato.getId(), prato);
		saveAll();
	}

	public Map<UUID, Prato> getPratos() {
		return pratos;
	}
}