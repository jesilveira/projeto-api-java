package com.gft.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.consumoapiexterna.service.impl.CepServiceImpl;
import com.gft.entities.Fornecedor;
import com.gft.exception.EntityNotFoundException;
import com.gft.repositories.FornecedorRepository;
import com.gft.repositories.PecaRepository;
import com.gft.response.CepResponse;

@Service
public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;

	private final PecaRepository pecaRepository;

	private final CepServiceImpl cepServiceImpl;

	private CepResponse cepResponse;

	public FornecedorService(FornecedorRepository fornecedorRepository, PecaRepository pecaRepository,
			CepServiceImpl cepServiceImpl) {
		this.fornecedorRepository = fornecedorRepository;
		this.pecaRepository = pecaRepository;
		this.cepServiceImpl = cepServiceImpl;
	}

	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		cepResponse = buscarEndereco(fornecedor.getEndereco().getCep());

		fornecedor.getEndereco().setLogradouro(cepResponse.logradouro);
		fornecedor.getEndereco().setLocalidade(cepResponse.localidade);
		fornecedor.getEndereco().setUf(cepResponse.uf);
		fornecedor.getEndereco().setBairro(cepResponse.bairro);
		fornecedor.getEndereco().setDdd(cepResponse.ddd);

		return fornecedorRepository.save(fornecedor);
	}

	public Page<Fornecedor> listarTodosOsFornecedores(Pageable pageable) {
		return fornecedorRepository.findAll(pageable);
	}

	public Fornecedor buscarFornecedor(String cnpj) {
		Optional<Fornecedor> optional = fornecedorRepository.findById(cnpj);

		return optional.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado"));
	}

	public Fornecedor atualizarFornecedor(Fornecedor fornecedor, String cnpj) {
		Fornecedor fornecedorOriginal = this.buscarFornecedor(cnpj);

		fornecedor.setCnpj(fornecedorOriginal.getCnpj());

		return fornecedorRepository.save(fornecedor);
	}

	public void excluirFornecedor(String cnpj) {
		Fornecedor fornecedorOriginal = this.buscarFornecedor(cnpj);

		pecaRepository.deleteAllByFornecedor_Cnpj(cnpj);
		fornecedorRepository.delete(fornecedorOriginal);
	}

	public CepResponse buscarEndereco(String cep) {
		try {

			cepResponse = cepServiceImpl.getCEP(cep);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cepResponse;

	}
}
