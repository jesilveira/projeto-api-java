package com.gft.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Venda;
import com.gft.repositories.VendaRepository;

@Service
public class VendaService {

	private final VendaRepository vendaRepository;

	public VendaService(VendaRepository vendasRepository) {
		this.vendaRepository = vendasRepository;
	}

	public Venda salvarVenda(Venda venda) {

		return vendaRepository.save(venda);
	}

	public Page<Venda> listarTodasAsVendas(Pageable pageable) {
		return vendaRepository.findAll(pageable);
	}

	public Venda buscarVenda(Long id) {
		Optional<Venda> optional = vendaRepository.findById(id);

		return optional.orElseThrow(() -> new EntityNotFoundException("Venda não encontrada"));

	}

	public Venda atualizarVenda(Venda venda, Long id) {

		Venda vendaOriginal = this.buscarVenda(id);

		venda.setId(vendaOriginal.getId());

		return vendaRepository.save(venda);

	}

	public void excluirVenda(Long id) {
		Venda vendaOriginal = this.buscarVenda(id);

		vendaRepository.delete(vendaOriginal);

	}
}
