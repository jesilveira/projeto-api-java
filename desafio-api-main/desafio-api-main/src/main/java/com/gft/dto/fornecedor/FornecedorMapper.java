package com.gft.dto.fornecedor;

import com.gft.dto.endereco.EnderecoMapper;
import com.gft.entities.Fornecedor;

public class FornecedorMapper {

	public static Fornecedor fromDTO(RegistroFornecedorDTO dto) {
		return new Fornecedor(dto.getCnpj(), dto.getNome(), dto.getTelefone(), dto.getEmail(),
				EnderecoMapper.fromDTO(dto.getEndereco()));
	}

	public static ConsultaFornecedorDTO fromEntity(Fornecedor fornecedor) {
		return new ConsultaFornecedorDTO(fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getTelefone(),
				fornecedor.getEmail(), EnderecoMapper.fromEntity(fornecedor.getEndereco()));
	}
}
