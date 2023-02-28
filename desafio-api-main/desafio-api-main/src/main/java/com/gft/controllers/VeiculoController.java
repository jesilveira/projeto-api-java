package com.gft.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.veiculo.ConsultaVeiculoDTO;
import com.gft.dto.veiculo.RegistroVeiculoDTO;
import com.gft.dto.veiculo.VeiculoMapper;
import com.gft.entities.Veiculo;
import com.gft.services.VeiculoService;

@RestController
@RequestMapping("v1/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;

	@GetMapping("{id}")
	public ResponseEntity<ConsultaVeiculoDTO> buscarVeiculo(@PathVariable Long id) {
		try {
			Veiculo veiculo = service.buscarVeiculo(id);

			return ResponseEntity.status(200).body(VeiculoMapper.fromEntity(veiculo));
		} catch (EntityNotFoundException e) {

			return ResponseEntity.status(404).build();
		}

	}

	@PostMapping
	public ResponseEntity<ConsultaVeiculoDTO> salvarNovoVeiculo(@RequestBody RegistroVeiculoDTO dto) throws Exception {

		Veiculo veiculo = service.salvarNovoVeiculo(VeiculoMapper.fromDTO(dto));

		return ResponseEntity.status(201).body(VeiculoMapper.fromEntity(veiculo));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaVeiculoDTO> atualizarVeiculo(@PathVariable Long id,
			@RequestBody RegistroVeiculoDTO dto) throws Exception {

		try {
			Veiculo veiculo = service.atualizarVeiculo(id, VeiculoMapper.fromDTO(dto));

			return ResponseEntity.status(200).body(VeiculoMapper.fromEntity(veiculo));
		} catch (EntityNotFoundException e) {

			return ResponseEntity.status(404).build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaVeiculoDTO> excluirVeiculo(@PathVariable Long id) {

		try {
			service.excluirVeiculo(id);

			return ResponseEntity.status(200).build();
		} catch (EntityNotFoundException e) {

			return ResponseEntity.status(404).build();
		}
	}

}
