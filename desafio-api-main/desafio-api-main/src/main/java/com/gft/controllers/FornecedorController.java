package com.gft.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.fornecedor.ConsultaFornecedorDTO;
import com.gft.dto.fornecedor.FornecedorMapper;
import com.gft.dto.fornecedor.RegistroFornecedorDTO;
import com.gft.entities.Fornecedor;
import com.gft.services.FornecedorService;

@RestController
@RequestMapping("v1/fornecedores")
public class FornecedorController {

	private final FornecedorService fornecedorService;

	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaFornecedorDTO>> buscarTodosOsFornecedores(@PageableDefault Pageable pageable) {

		return ResponseEntity.status(201)
				.body(fornecedorService.listarTodosOsFornecedores(pageable).map(FornecedorMapper::fromEntity));
	}

	@PostMapping
	public ResponseEntity<ConsultaFornecedorDTO> salvarFornecedor(@RequestBody RegistroFornecedorDTO dto) {

		Fornecedor fornecedor = fornecedorService.salvarFornecedor(FornecedorMapper.fromDTO(dto));

		return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
	}

	@GetMapping("{cnpj}")
	public ResponseEntity<ConsultaFornecedorDTO> buscarFornecedor(@PathVariable String cnpj) {

		Fornecedor fornecedor = fornecedorService.buscarFornecedor(cnpj);

		return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
	}

	@PutMapping("{cnpj}")
	public ResponseEntity<ConsultaFornecedorDTO> alterarFornecedor(@RequestBody RegistroFornecedorDTO dto,
			@PathVariable String cnpj) {

		Fornecedor fornecedor = fornecedorService.atualizarFornecedor(FornecedorMapper.fromDTO(dto), cnpj);

		return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
	}

	@DeleteMapping("{cnpj}")
	public ResponseEntity<ConsultaFornecedorDTO> excluirFornecedor(@PathVariable String cnpj) {

		fornecedorService.excluirFornecedor(cnpj);

		return ResponseEntity.ok().build();
	}
}
