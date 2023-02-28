package com.gft.dto.venda;

import com.gft.entities.Venda;

public class VendaMapper {

	public static Venda fromDTO(RegistroVendaDTO dto) {
		return new Venda(null, dto.getItens(), dto.getQuantidade(), dto.getValorUnitario(), dto.getValorTotal(),
				dto.getCliente());
	}

	public static ConsultaVendaDTO fromEntity(Venda venda) {
		return new ConsultaVendaDTO(venda.getId(), venda.getItens(), venda.getQuantidade(), venda.getValorUnitario(),
				venda.getValorTotal(), venda.getCliente());
	}
}
