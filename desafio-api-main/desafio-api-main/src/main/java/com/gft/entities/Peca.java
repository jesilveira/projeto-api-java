package com.gft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_peca")
public class Peca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Fornecedor fornecedor;

	private String marca;

	private String tempoEntrega;

	private String qualidade;

	private Double valorUnitario;

	private Integer quantidade;

	private Double valorTotal;

	public Peca() {
	}

	public Peca(Long id, String descricao, Categoria categoria, Fornecedor fornecedor, String marca,
			String tempoEntrega, String qualidade, Double valorUnitario, Integer quantidade) {
		this.id = id;
		this.descricao = descricao;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.marca = marca;
		this.tempoEntrega = tempoEntrega;
		this.qualidade = qualidade;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
		this.valorTotal = valorUnitario * quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTempoEntrega() {
		return tempoEntrega;
	}

	public void setTempoEntrega(String tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
