package com.gft.response;

import java.io.Serializable;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */


public class CepResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	    public String cep;
	    public String logradouro;
	    public String complemento;
	    public String bairro;
	    public String localidade;
	    public String uf;
	    public String ibge;
	    public String gia;
	    public String ddd;
	    public String siafi;
	    
		public CepResponse() {
		}
		
		public CepResponse(String cep, String logradouro, String complemento, String bairro, String localidade,
				String uf, String ibge, String gia, String ddd, String siafi) {
			this.cep = cep;
			this.logradouro = logradouro;
			this.complemento = complemento;
			this.bairro = bairro;
			this.localidade = localidade;
			this.uf = uf;
			this.ibge = ibge;
			this.gia = gia;
			this.ddd = ddd;
			this.siafi = siafi;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public String getLogradouro() {
			return logradouro;
		}
		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}
		public String getComplemento() {
			return complemento;
		}
		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
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
		public String getIbge() {
			return ibge;
		}
		public void setIbge(String ibge) {
			this.ibge = ibge;
		}
		public String getGia() {
			return gia;
		}
		public void setGia(String gia) {
			this.gia = gia;
		}
		public String getDdd() {
			return ddd;
		}
		public void setDdd(String ddd) {
			this.ddd = ddd;
		}
		public String getSiafi() {
			return siafi;
		}
		public void setSiafi(String siafi) {
			this.siafi = siafi;
		}
	    
}
