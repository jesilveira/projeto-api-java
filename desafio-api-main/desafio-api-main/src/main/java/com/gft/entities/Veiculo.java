package com.gft.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "marca", nullable = false)
	private String marca;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "valorVenda", nullable = false)
	private double valorVenda;

	@Column(name = "custoProducao", nullable = false)
	private double custoProducao;

	@Column(name = "tempoEntrega", nullable = false)
	private String tempoEntrega;

	@ManyToMany
	private List<Peca> pecas;

	public Veiculo() {
	}

	public Veiculo(Long id, String marca, String descricao, double valorVenda, double custoProducao,
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
