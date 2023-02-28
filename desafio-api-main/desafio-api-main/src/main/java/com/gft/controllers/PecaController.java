package com.gft.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.peca.ConsultaPecaDTO;
import com.gft.dto.peca.PecaMapper;
import com.gft.dto.peca.RegistroPecaDTO;
import com.gft.entities.Peca;
import com.gft.services.PecaService;

@RestController
@RequestMapping("v1/pecas")
public class PecaController {

	private final PecaService pecaService;

	public PecaController(PecaService pecaService) {
		this.pecaService = pecaService;
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaPecaDTO> buscarPeca(@PathVariable Long id) {

		Peca peca = pecaService.buscarPeca(id);

		return ResponseEntity.status(200).body(PecaMapper.fromEntity(peca));
	}

	@PostMapping
	public ResponseEntity<ConsultaPecaDTO> salvarPeca(@RequestBody RegistroPecaDTO dto) throws Exception {

		Peca peca;

		peca = pecaService.salvarPeca(PecaMapper.fromDTO(dto));

		return ResponseEntity.status(201).body(PecaMapper.fromEntity(peca));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaPecaDTO> editarPeca(@PathVariable Long id, @RequestBody RegistroPecaDTO dto)
			throws Exception {

		Peca peca = pecaService.editarPeca(id, PecaMapper.fromDTO(dto));

		return ResponseEntity.status(200).body(PecaMapper.fromEntity(peca));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaPecaDTO> excluirPeca(@PathVariable Long id) {

		pecaService.apagarPeca(id);

		return ResponseEntity.status(200).build();
	}
}
