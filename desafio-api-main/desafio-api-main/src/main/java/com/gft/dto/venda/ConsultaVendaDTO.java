package com.gft.dto.venda;

import java.util.List;

import com.gft.entities.Cliente;

public class ConsultaVendaDTO {

	private Long id;

	private String itens;

	private Integer quantidade;

	private Double valorUnitario;

	private Double valorTotal;

	private List<Cliente> cliente;

	public ConsultaVendaDTO() {

	}

	public ConsultaVendaDTO(Long id, String itens, Integer quantidade, Double valorUnitario, Double valorTotal,
			List<Cliente> cliente) {

		this.id = id;
		this.itens = itens;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.cliente = cliente;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItens() {
		return itens;
	}

	public void setItens(String itens) {
		this.itens = itens;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

}
