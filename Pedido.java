import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
	// Attributes
	
	private UUID id;
	private double valorTotal = 0.0;
	private String status;
	private List<Prato> pratos = new ArrayList<>();

	// Realizado (o processamento)
	// Confirmado (para preparo) 
	// Encaminhado (ao destino)
	// Concluído

	// Constructors
	
	Pedido() {
		this.id = UUID.randomUUID();
		this.status = "Realizado";
	}

	Pedido(UUID id, double valorTotal, String status) {
		this.id = id;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	// Getters
	
	public UUID getId() {
		return id;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public String getStatus() {
		return status;
	}
	
	public List<Prato> getPratos() {
		return pratos;
	}

	// Setters
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	// Add methods
	
	public void addPrato(Prato prato) {
		pratos.add(prato);
		valorTotal += prato.getPreco();
	}

}