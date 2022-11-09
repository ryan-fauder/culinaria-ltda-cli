import java.io.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.UUID;

class PratoDao implements BasicDao<UUID, Prato> {
	private static PratoDao instance;
	private BufferedReader reader = null;
	private PrintWriter writer = null;
	private Map<UUID, Prato> pratos = new LinkedHashMap<>();
	private ArrayList<Prato> pratosList = new ArrayList<>();
	private static String fileName = "data/pratos.txt";

	private PratoDao(){
		getAll();
	}
	
	public static PratoDao getInstance() {
		return instance == null ? new PratoDao() : instance;
	}

	@Override
	public Optional<Prato> get(UUID id) {
		return Optional.ofNullable(this.pratos.get(id));
	}

	public Optional<Prato> get(int index) {
		return Optional.ofNullable(this.pratosList.get(index));
	}
	
	@Override
	public Map<UUID, Prato> getAll() {
		if (!this.pratos.isEmpty()) {
			return this.pratos;
		}

		try {
			reader = new BufferedReader(
						new InputStreamReader(
							new FileInputStream(fileName)));

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
		catch (InvalidStringException isException) {
			// Alguma String contém ';'
			isException.printStackTrace();
		}
		catch (InvalidPriceException ipException) {
			// Preço inválido (<= 0)
			ipException.printStackTrace();
		}
		finally {
			try { if (reader != null) reader.close(); } 
			catch (IOException ioException) { ioException.printStackTrace(); }
		}
		
		return this.pratos;
	}
	
	@Override
	public void save(Prato prato) {
		if (pratos.containsKey(prato.getId())) return;

		try {
			writer = new PrintWriter(
				new OutputStreamWriter(
					new FileOutputStream(fileName, true)));

			// id; nome; preço; descrição
			writer.print(prato.getId().toString() + ";");
			writer.print(prato.getNome() + ";");
			writer.print(String.format("%.2f", prato.getPreco()) + ";");
			writer.println(prato.getDescricao());

			pratos.put(prato.getId(), prato);
			setList();
		}
		catch (IOException ioException) {
			ioException.printStackTrace();
		}
		catch (NullPointerException npException) {
			// Objeto "prato" nulo
			npException.printStackTrace();
		}
		catch(Exception exception){
			exception.printStackTrace();
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
					new FileOutputStream(fileName)));
				
			// id; nome; preço; descrição
			for (Prato prato : pratos.values()) {
				if (prato == null)
					throw new NullPointerException();
				writer.print(prato.getId().toString() + ";");
				writer.print(prato.getNome() + ";");
				writer.print(String.format("%.2f", prato.getPreco()) + ";");
				writer.println(prato.getDescricao());
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
	public void delete(Prato prato) {
		try {
			this.pratos.remove(prato.getId());
			setList();
			saveAll();
		}
		catch (NullPointerException npException) {
			// Objeto "prato" nulo
			npException.printStackTrace();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	@Override
	public void update(Prato prato) {
		try {
			this.pratos.replace(prato.getId(), prato);
			setList();
			saveAll();
		}
		catch (NullPointerException npException) {
			// Objeto "prato" nulo
			npException.printStackTrace();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public Map<UUID, Prato> getPratos() {
		return pratos;
	}
	
	public ArrayList<Prato> getList() {
		if (pratos.isEmpty()){
			getAll();
		}
		if (pratosList.isEmpty()) {
			pratosList = new ArrayList<Prato>(pratos.values());
		}
		return pratosList;
	}

	public void setList(){
		pratosList = new ArrayList<Prato>(pratos.values());
	}
}