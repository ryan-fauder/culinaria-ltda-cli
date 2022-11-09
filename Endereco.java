public class Endereco {
	// Attributes

	private String estado, cidade, rua, complemento, bairro, cep, numero;
  
	public Endereco(){
	
	}

  public Endereco(String estado, String cidade, String rua, 
    String complemento, String bairro, String cep, String numero) {
    this.estado = estado;
    this.cidade = cidade;
    this.rua = rua;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cep = cep;
    this.numero = numero;
  }

	// Getters
	
	public String getEstado() {
		return estado;
	}
	
  public String getCidade() {
    return cidade;
  }
	
  public String getRua() {
    return rua;
  }
	
  public String getComplemento() {
    return complemento;
  }

  public String getCep() {
    return cep;
  }
	
  public String getBairro() {
    return bairro;
  }
  
  public String getNumero() {
    return numero;
  }

	// Setters
	
  public void setEstado(String estado) {
    this.estado = estado;
  }
  
  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
  
  public void setRua(String rua) {
    this.rua = rua;
  }
  
  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }
  
  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
  
  public void setCep(String cep) {
    this.cep = cep;
  }
  
  public void setNumero(String numero) {
    this.numero = numero;
  }

  @Override
  public String toString() {
		return "Rua " + rua + "; " + "No. " + numero +
				"; " + complemento + "; " + bairro
				+ "; " + cidade + " - " + estado
				+ ". CEP: " + cep;
	}
	
}