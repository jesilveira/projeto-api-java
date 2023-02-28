package com.gft.dto.endereco;

public class EnderecoDTO {

	
	private String localidade;
	private String uf;
	private String bairro;
	private String ddd;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	
	public EnderecoDTO() {
	}
	
	public EnderecoDTO(String localidade, String uf, String bairro, String ddd,String logradouro, String numero, String complemento, String cep) {
		
		this.localidade = localidade;
		this.uf = uf;
		this.bairro = bairro;
		this.ddd = ddd;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		
	}
	
	
	
	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

}
