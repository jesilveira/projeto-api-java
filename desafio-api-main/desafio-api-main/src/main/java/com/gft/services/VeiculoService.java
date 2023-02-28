package com.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Peca;
import com.gft.entities.Veiculo;
import com.gft.exception.EntityNotFoundException;
import com.gft.repositories.PecaRepository;
import com.gft.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private PecaService pecaService;

	@Autowired
	private PecaRepository pecaRepository;

	public Veiculo salvarNovoVeiculo(Veiculo veiculo) throws Exception {

		List<Peca> pecasDoVeiculo = veiculo.getPecas();

		for (Peca pecaDoVeiculo : pecasDoVeiculo) {

			Peca peca = pecaService.buscarPeca(pecaDoVeiculo.getId());

			peca.setQuantidade(peca.getQuantidade() - 1);

			pecaService.checarLimiteMinimo(peca);

			pecaRepository.save(peca);
		}

		return repository.save(veiculo);
	}

	public Page<Veiculo> listarTodosVeiculos(Pageable pageable) {

		return repository.findAll(pageable);
	}

	public Veiculo buscarVeiculo(Long id) {
		Optional<Veiculo> optional = repository.findById(id);

		return optional.orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado"));
	}

	public Veiculo atualizarVeiculo(Long id, Veiculo veiculo) throws Exception {

		Veiculo veiculoOriginal = this.buscarVeiculo(id);

		veiculo.setId(veiculoOriginal.getId());
		
		List<Peca> pecasDoVeiculo = veiculo.getPecas();

		for (Peca pecaDoVeiculo : pecasDoVeiculo) {

			Peca peca = pecaService.buscarPeca(pecaDoVeiculo.getId());

			peca.setQuantidade(peca.getQuantidade() - 1);

			pecaService.checarLimiteMinimo(peca);

			pecaRepository.save(peca);
		}

		return repository.save(veiculo);
	}

	public void excluirVeiculo(Long id) {
		Veiculo veiculoOriginal = this.buscarVeiculo(id);

		repository.delete(veiculoOriginal);
	}
}
