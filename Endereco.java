public class Endereco {
	// Attributes
	private String estado, cidade, rua, complemento, bairro, cep, numero;
	public Endereco(){
	
	}
	
  /*"Quarto em baixo do armário, Rua dos Alfeneiros, Quadra 123, Lote 321, Número 69, CEP 4002-8922, Setor Jd. Guanabara, The Paris Cida (Aparecida de Goiânia), Goiás, Brasil, América do Sul, América, Hemisfério Sul, Planeta Terra, Sistema Solar, Via Láctea, Universo 1, Multiverso da loucura, Dimensão 26, Quadrante: Segredo, Coordenadas: 6526'27'' S, 2156'897'' O   ";
		*/
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

	
}