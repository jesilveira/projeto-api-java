package com.gft.dto.endereco;

import com.gft.entities.Endereco;

public class EnderecoMapper {
	
	public static Endereco fromDTO(EnderecoDTO dto) {
		return new Endereco(dto.getLocalidade(), dto.getUf(), dto.getBairro(), dto.getDdd(), dto.getLogradouro(), dto.getNumero(), dto.getComplemento(), dto.getCep());
	}

	public static EnderecoDTO fromEntity(Endereco endereco) {
		return new EnderecoDTO(endereco.getLocalidade(), endereco.getUf(), endereco.getBairro(), endereco.getDdd(), endereco.getLogradouro(), endereco.getNumero(),
				endereco.getComplemento(), endereco.getCep());
	}
	
}
