package com.gft.dto.veiculo;

import com.gft.entities.Veiculo;

public class VeiculoMapper {

	public static Veiculo fromDTO(RegistroVeiculoDTO dto) {
		return new Veiculo(null, dto.getMarca(), dto.getDescricao(), dto.getValorVenda(), dto.getCustoProducao(),
				dto.getTempoEntrega(), dto.getPecas());
	}

	public static ConsultaVeiculoDTO fromEntity(Veiculo veiculo) {
		return new ConsultaVeiculoDTO(veiculo.getId(), veiculo.getMarca(), veiculo.getDescricao(),
				veiculo.getValorVenda(), veiculo.getCustoProducao(), veiculo.getTempoEntrega(),
				veiculo.getPecas());
	}

}
