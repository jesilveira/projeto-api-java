package com.gft.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	private String nome;

	private Integer limiteMinimo;

	private Integer limiteMaximo;

	public Categoria() {
	}

	public Categoria(String nome, Integer limiteMinimo, Integer limiteMaximo) {
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
