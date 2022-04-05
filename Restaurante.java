import java.util.List;
import java.util.ArrayList;

public class Restaurante {
	// Attributes

	private String nome, descricao;
	private int cnpj;
	private Endereco endereco;
	private List<Pedido> pedidos = new ArrayList<>();
	private List<Prato> pratos = new ArrayList<>();

	// Constructor

	public Restaurante(){
			
	}

	// Getters

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	// Setters

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// Add methods
	
	public void addPedido(Pedido pedido){
		pedidos.add(pedido);
	}
	
	public void addPrato(Prato prato){
		pratos.add(prato);
	}
	
}