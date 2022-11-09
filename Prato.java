import java.util.UUID;

public class Prato {
	// Attributes
	
	private UUID id;
 	private String nome;
 	private double preco;
 	private String descricao;

	// Constructors
	
	public Prato() {
		id = UUID.randomUUID();
	}
	
	public Prato(UUID id, String nome, double preco, 
				 String descricao) throws InvalidStringException, InvalidPriceException {
		this.id = id;
		setNome(nome);
		setPreco(preco);
		setDescricao(descricao);
	}
	
	public Prato(String nome, double preco, String descricao) 
				throws InvalidStringException, InvalidPriceException {
		id = UUID.randomUUID();
		setNome(nome);
		setPreco(preco);
		setDescricao(descricao);
	}
	
	
	// Getters
	
	public UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
		
	public String getDescricao() {
		return descricao;
	}
	
	public double getPreco() {
		return preco;
	}

	// Setters
	
	public void setPreco(double preco) throws InvalidPriceException {
		if (preco < 0)
			throw new InvalidPriceException(preco);
		this.preco = preco;
	}
	
	public void setNome(String nome) throws InvalidStringException {
		if (nome.contains(";"))
			throw new InvalidStringException(nome);
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) throws InvalidStringException {
		if (descricao.contains(";"))
			throw new InvalidStringException(nome);
		this.descricao = descricao;
	}

	// toString
	@Override
	public String toString() {
		return "Prato [descricao=" + descricao + ", nome=" + nome + ", preco=" + preco + "]\n";
	}

}
