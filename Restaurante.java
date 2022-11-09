public class Restaurante {
	// Attributes

	private String nome = "Culinaria Ltda.";
	private String descricao = "Atendendo seu estomago ha mais de 50 anos, mas nao o seu paladar!";
	private String cnpj = "55.318.925/0001-77";
	private Endereco endereco = new Endereco("GO", "Goiania", "R-28", 
											 "Qd 125, Lt 19", "Goiania 2", "74685-610", "42");

	// Constructor

	public Restaurante() {
	}

	// Getters

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	// Setters

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCnpj(String cnpj) {
	  this.cnpj = cnpj;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}