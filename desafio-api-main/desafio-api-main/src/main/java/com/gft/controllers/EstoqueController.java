package com.gft.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.peca.ConsultaPecaDTO;
import com.gft.dto.peca.PecaMapper;
import com.gft.dto.veiculo.ConsultaVeiculoDTO;
import com.gft.dto.veiculo.VeiculoMapper;
import com.gft.entities.Peca;
import com.gft.services.PecaService;
import com.gft.services.VeiculoService;

@RestController
@RequestMapping("v1/estoque")
public class EstoqueController {

	private final PecaService pecaService;

	private final VeiculoService veiculoService;

	public EstoqueController(PecaService pecaService, VeiculoService veiculoService) {
		this.pecaService = pecaService;
		this.veiculoService = veiculoService;
	}

	@GetMapping("/veiculos")
	public ResponseEntity<Page<ConsultaVeiculoDTO>> buscarTodosOsVeiculos(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(veiculoService.listarTodosVeiculos(pageable).map(VeiculoMapper::fromEntity));
	}

	@GetMapping("/pecas")
	public ResponseEntity<Page<ConsultaPecaDTO>> buscarTodasAsPecas(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(pecaService.listarPecas(pageable).map(PecaMapper::fromEntity));
	}

	@GetMapping("pecas/categoria/{categoria}")
	public ResponseEntity<Page<ConsultaPecaDTO>> buscarPecasPorCategoria(@PageableDefault Pageable pageable,
			@PathVariable String categoria) {

		Page<ConsultaPecaDTO> page = pecaService.listarPecasPorCategoria(categoria, pageable)
				.map(PecaMapper::fromEntity);

		return ResponseEntity.status(200).body(page);
	}

	@GetMapping("pecas/fornecedor/{cnpj}")
	public ResponseEntity<Page<ConsultaPecaDTO>> buscarPecasPorFornecedor(@PageableDefault Pageable pageable,
			@PathVariable String cnpj) {

		return ResponseEntity.ok(pecaService.listarPecasPorFornecedor(cnpj, pageable).map(PecaMapper::fromEntity));
	}

	@GetMapping("/valorTotal")
	public double valorTotalEstoque() {
		return pecaService.valorTotal();

	}

	@GetMapping("/totalCategoria/{categoria}")
	public double valorTotalEstoqueCategoria(@PathVariable String categoria) {
		List<Peca> pecas = pecaService.filtarCategoria(categoria);

		double sum = 0;
		for (Peca peca : pecas) {
			sum += peca.getValorTotal();
		}

		return sum;

	}
}
