package com.gft.dto.peca;

import com.gft.dto.categoria.CategoriaMapper;
import com.gft.entities.Peca;

public class PecaMapper {

	public static Peca fromDTO(RegistroPecaDTO dto) {

		return new Peca(null, dto.getDescricao(), CategoriaMapper.fromDTO(dto.getCategoria()), dto.getFornecedor(),
				dto.getMarca(), dto.getTempoEntrega(), dto.getQualidade(), dto.getValorUnitario(), dto.getQuantidade());
	}

	public static ConsultaPecaDTO fromEntity(Peca peca) {

		return new ConsultaPecaDTO(peca.getId(), peca.getDescricao(), CategoriaMapper.fromEntity(peca.getCategoria()),
				peca.getFornecedor(), peca.getMarca(), peca.getTempoEntrega(), peca.getQualidade(),
				peca.getValorUnitario(), peca.getQuantidade());
	}
}
