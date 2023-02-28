package com.gft.dto.venda;

import java.util.List;

import com.gft.entities.Cliente;
import com.gft.entities.Peca;
import com.gft.entities.Veiculo;

public class RegistroVendaDTO {

	private Long id;

	private String itens;

	private Integer quantidade;

	private Double valorUnitario;

	private Double valorTotal;

	private List<Cliente> cliente;

	private List<Peca> pecas;

	private List<Veiculo> veiculo;

	public RegistroVendaDTO() {

	}

	public RegistroVendaDTO(Long id, String itens, Integer quantidade, Double valorUnitario, Double valorTotal,
			List<Cliente> cliente, List<Peca> pecas, List<Veiculo> veiculo) {

		this.id = id;
		this.itens = itens;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.pecas = pecas;
		this.veiculo = veiculo;
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

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
}
