package com.gft.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.categoria.CategoriaDTO;
import com.gft.dto.categoria.CategoriaMapper;
import com.gft.entities.Categoria;
import com.gft.services.CategoriaService;

@RestController
@RequestMapping("/v1/categoria")
public class CategoriaController {

	private final CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> salvarCategoria(@RequestBody CategoriaDTO dto) {

		Categoria categoria = categoriaService.salvarCategoria(CategoriaMapper.fromDTO(dto));

		return ResponseEntity.status(201).body(CategoriaMapper.fromEntity(categoria));
	}

	@PutMapping("/{nome}")
	public ResponseEntity<CategoriaDTO> editarLimitesDaCategoria(@PathVariable String nome,
			@RequestBody CategoriaDTO dto) {

		Categoria categoria = categoriaService.editarLimites(nome, CategoriaMapper.fromDTO(dto));

		return ResponseEntity.status(200).body(CategoriaMapper.fromEntity(categoria));
	}

	@DeleteMapping("/{nome}")
	public ResponseEntity<CategoriaDTO> excluirCategoria(@PathVariable String nome) {

		categoriaService.excluirCategoria(nome);

		return ResponseEntity.status(200).build();
	}
}
