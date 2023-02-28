package com.gft.dto.peca;

import com.gft.dto.categoria.CategoriaDTO;
import com.gft.entities.Fornecedor;

public class ConsultaPecaDTO {

	private Long id;

	private String descricao;

	private CategoriaDTO categoria;

	private Fornecedor fornecedor;

	private String marca;

	private String tempoEntrega;

	private String qualidade;

	private Double valorUnitario;

	private Integer quantidade;

	private Double valorTotal;

	public ConsultaPecaDTO() {
	}

	public ConsultaPecaDTO(Long id, String descricao, CategoriaDTO categoria, Fornecedor fornecedor, String marca,
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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
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
