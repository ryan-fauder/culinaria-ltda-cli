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
	
	public Prato(String nome, double preco, String descricao) {
		id = UUID.randomUUID();
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	public Prato(UUID id, String nome, double preco, String descricao) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	// Getters
	
	public UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}

	// Setters
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// toString

	@Override
	public String toString() {
		return "Prato [descricao=" + descricao + ", nome=" + nome + ", preco=" + preco + "]\n";
	}

}
