package com.gft.dto.categoria;

public class CategoriaDTO {

	private String nome;
	private Integer limiteMinimo;
	private Integer limiteMaximo;

	public CategoriaDTO() {
	}

	public CategoriaDTO(String nome, Integer limiteMinimo, Integer limiteMaximo) {
		this.nome = nome;
		this.limiteMinimo = limiteMinimo;
		this.limiteMaximo = limiteMaximo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getLimiteMinimo() {
		return limiteMinimo;
	}

	public void setLimiteMinimo(Integer limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}

	public Integer getLimiteMaximo() {
		return limiteMaximo;
	}

	public void setLimiteMaximo(Integer limiteMaximo) {
		this.limiteMaximo = limiteMaximo;
	}
}
