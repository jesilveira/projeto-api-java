package com.gft.dto.categoria;

import com.gft.entities.Categoria;

public class CategoriaMapper {

	public static Categoria fromDTO(CategoriaDTO dto) {

		return new Categoria(dto.getNome(), dto.getLimiteMinimo(), dto.getLimiteMaximo());
	}

	public static CategoriaDTO fromEntity(Categoria categoria) {

		return new CategoriaDTO(categoria.getNome(), categoria.getLimiteMinimo(), categoria.getLimiteMaximo());
	}
}
