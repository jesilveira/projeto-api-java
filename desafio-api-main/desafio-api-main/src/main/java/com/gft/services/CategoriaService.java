package com.gft.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gft.entities.Categoria;
import com.gft.exception.EntityNotFoundException;
import com.gft.repositories.CategoriaRepository;
import com.gft.repositories.PecaRepository;

@Service
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;

	private final PecaRepository pecaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository, PecaRepository pecaRepository) {
		this.categoriaRepository = categoriaRepository;
		this.pecaRepository = pecaRepository;
	}

	public Categoria buscarCategoria(String nome) {

		Optional<Categoria> optional = categoriaRepository.findById(nome);

		return optional.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada."));
	}

	public Categoria salvarCategoria(Categoria categoria) {

		return categoriaRepository.save(categoria);
	}

	public Categoria editarLimites(String nome, Categoria categoria) {

		Categoria categoriaOriginal = this.buscarCategoria(nome);

		categoria.setNome(categoriaOriginal.getNome());

		return categoriaRepository.save(categoria);
	}

	public void excluirCategoria(String nome) {

		Categoria categoria = this.buscarCategoria(nome);

		pecaRepository.deleteAllByCategoria_Nome(nome);
		categoriaRepository.delete(categoria);
	}
}
