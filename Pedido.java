import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
	// Attributes
	
	private UUID id;
	private double valorTotal = 0.0;
	private String status;
	private List<Prato> pratos = new ArrayList<>();

	// Constructors
	
	Pedido() {
		this.id = UUID.randomUUID();
		this.status = "Realizado";
	}

	Pedido(UUID id, double valorTotal, String status) throws InvalidStringException {
		this.id = id;
		this.valorTotal = valorTotal;
		setStatus(status);
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
	
	public void setStatus(String status) throws InvalidStringException {
		/* 
	 	 * Realizado
		 * Confirmado
		 * Encaminhado
		 * Concluido
		 */ 
		if (status.equals("Realizado") || status.equals("Confirmado")
			|| status.equals("Encaminhado") || status.equals("Concluido")) {
			this.status = status;
		}
		else {
			throw new InvalidStringException(status);
		}
	}
	
	public void setValorTotal() {
		this.valorTotal = valorTotal;
	}

	// Add methods
	
	public void addPrato(Prato prato) {
		pratos.add(prato);
		valorTotal += prato.getPreco();
	}

}