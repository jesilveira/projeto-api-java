package com.gft.dto.veiculo;

import java.util.List;

import com.gft.entities.Peca;

public class ConsultaVeiculoDTO {
	
	private Long id; 
	
	private String marca;

	private String descricao;

	private double valorVenda;

	private double custoProducao;

	private String tempoEntrega;

	private List<Peca> pecas;

	public ConsultaVeiculoDTO() {
	}

	public ConsultaVeiculoDTO(Long id, String marca, String descricao, double valorVenda, double custoProducao,
			String tempoEntrega, List<Peca> pecas) {
		this.id = id;
		this.marca = marca;
		this.descricao = descricao;
		this.valorVenda = custoProducao + (custoProducao * 7.5);
		this.custoProducao = custoProducao;
		this.tempoEntrega = tempoEntrega;
		this.pecas = pecas;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public double getCustoProducao() {
		return custoProducao;
	}

	public void setCustoProducao(double custoProducao) {
		this.custoProducao = custoProducao;
	}

	public String getTempoEntrega() {
		return tempoEntrega;
	}

	public void setTempoEntrega(String tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

}
