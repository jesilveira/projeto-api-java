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

import com.gft.dto.venda.ConsultaVendaDTO;
import com.gft.dto.venda.RegistroVendaDTO;
import com.gft.dto.venda.VendaMapper;
import com.gft.entities.Venda;
import com.gft.services.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

	private final VendaService vendaService;

	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}

	@PostMapping
	public ResponseEntity<ConsultaVendaDTO> salvarVenda(@RequestBody RegistroVendaDTO dto) {

		Venda venda = vendaService.salvarVenda(VendaMapper.fromDTO(dto));

		return ResponseEntity.ok(VendaMapper.fromEntity(venda));
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaVendaDTO>> buscarTodasAsVendas(@PageableDefault Pageable pageable) {
		return ResponseEntity.ok(vendaService.listarTodasAsVendas(pageable).map(VendaMapper::fromEntity));
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaVendaDTO> buscarVenda(@PathVariable Long id) {

		Venda venda = vendaService.buscarVenda(id);

		return ResponseEntity.ok(VendaMapper.fromEntity(venda));

	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaVendaDTO> alterarVenda(@RequestBody RegistroVendaDTO dto, @PathVariable Long id) {

		try {

			Venda venda = vendaService.atualizarVenda(VendaMapper.fromDTO(dto), id);

			return ResponseEntity.ok(VendaMapper.fromEntity(venda));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaVendaDTO> excluirVenda(@PathVariable Long id) {

		try {
			vendaService.excluirVenda(id);

			return ResponseEntity.ok().build();
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}

	}
}
