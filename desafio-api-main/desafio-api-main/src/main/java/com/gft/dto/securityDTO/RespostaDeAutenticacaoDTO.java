package com.gft.dto.securityDTO;

public class RespostaDeAutenticacaoDTO {
	
	private String tokenAcesso;
	private String TipoDeToken = "Bearer ";
	
	public RespostaDeAutenticacaoDTO(String tokenAcesso) {
		this.tokenAcesso = tokenAcesso;
	}

	public String getTokenAcesso() {
		return tokenAcesso;
	}

	public void setTokenAcesso(String tokenAcesso) {
		this.tokenAcesso = tokenAcesso;
	}

	public String getTipoDeToken() {
		return TipoDeToken;
	}

	public void setTipoDeToken(String tipoDeToken) {
		TipoDeToken = tipoDeToken;
	}

}
