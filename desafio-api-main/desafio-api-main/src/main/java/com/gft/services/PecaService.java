package com.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Categoria;
import com.gft.entities.Peca;
import com.gft.exception.EntityNotFoundException;
import com.gft.exception.ExceededLimitException;
import com.gft.exception.MinimumLimitException;
import com.gft.repositories.CategoriaRepository;
import com.gft.repositories.PecaRepository;

@Service
public class PecaService {

	private final PecaRepository pecaRepository;

	private final CategoriaRepository categoriaRepository;

	public PecaService(PecaRepository pecaRepository, CategoriaRepository categoriaRepository) {
		this.pecaRepository = pecaRepository;
		this.categoriaRepository = categoriaRepository;
	}

	public Page<Peca> listarPecas(Pageable pageable) {

		Page<Peca> pecas = pecaRepository.findAll(pageable);

		if (pecas.isEmpty())
			throw new EntityNotFoundException("Nenhuma peça foi encontrada.");

		return pecas;
	}

	public Page<Peca> listarPecasPorCategoria(String categoria, Pageable pageable) {

		Page<Peca> pecas = pecaRepository.findAllByCategoria_Nome(categoria, pageable);

		if (pecas.isEmpty())
			throw new EntityNotFoundException("Não existem peças registradas nesta categoria.");
		return pecas;
	}

	public Page<Peca> listarPecasPorFornecedor(String cnpj, Pageable pageable) {

		Page<Peca> pecas = pecaRepository.findAllByFornecedor_Cnpj(cnpj, pageable);

		if (pecas.isEmpty())
			throw new EntityNotFoundException("Não existem peças deste fornecedor registradas.");
		return pecas;
	}

	public Peca salvarPeca(Peca peca) throws Exception {

		checarLimiteMaximo(peca);

		return pecaRepository.save(peca);
	}

	public void checarLimiteMaximo(Peca peca) throws Exception {
		Categoria categoria = categoriaRepository.findById(peca.getCategoria().getNome()).get();

		List<Peca> pecasDaCategoria = pecaRepository.findAllByCategoria_Nome(categoria.getNome());

		Integer quantidadePecas = 0;

		for (Peca pecaDaCategoria : pecasDaCategoria) {
			quantidadePecas += pecaDaCategoria.getQuantidade();
		}

		if (peca.getQuantidade() + quantidadePecas > categoria.getLimiteMaximo())
			throw new ExceededLimitException("Limite máximo de peças da categoria " + categoria.getNome()
					+ " atingido! Não foi possível realizar a ação.");
	}

	public void checarLimiteMinimo(Peca peca) throws Exception {
		Categoria categoria = categoriaRepository.findById(peca.getCategoria().getNome()).get();

		List<Peca> pecasDaCategoria = pecaRepository.findAllByCategoria_Nome(categoria.getNome());

		Integer quantidadePecas = 0;

		for (Peca pecaDaCategoria : pecasDaCategoria) {
			quantidadePecas += pecaDaCategoria.getQuantidade();
		}

		if (quantidadePecas < categoria.getLimiteMinimo())
			throw new MinimumLimitException("Limite mínimo de peças da categoria " + categoria.getNome()
					+ " atingido! Não foi possível realizar a ação.");
	}

	public Peca buscarPeca(Long id) {

		Optional<Peca> peca = pecaRepository.findById(id);

		return peca.orElseThrow(() -> new EntityNotFoundException("Peça não encontrada."));
	}

	public Peca editarPeca(Long id, Peca peca) throws Exception {

		Peca pecaOriginal = this.buscarPeca(id);
		peca.setId(pecaOriginal.getId());

		checarLimiteMaximo(peca);
		checarLimiteMinimo(peca);

		return pecaRepository.save(peca);
	}

	public void apagarPeca(Long id) {

		Peca peca = this.buscarPeca(id);

		pecaRepository.delete(peca);
	}

	public double valorTotal() {
		return pecaRepository.findByValorTotal();
	}

	public List<Peca> filtarCategoria(String categoria) {
		return pecaRepository.findAllByCategoria_Nome(categoria);
	}
}
