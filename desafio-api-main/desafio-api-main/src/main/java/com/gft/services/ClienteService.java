package com.gft.services;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Cliente;
import com.gft.repositories.ClienteRepository;



@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	public Cliente salvarCliente(Cliente cliente) {
		
		return clienteRepository.save(cliente);
		
	}
	
	public Page<Cliente> listarTodosOsClientes(Pageable pageable){
		
		return clienteRepository.findAll(pageable);
		
	}

	public Cliente buscarCliente(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		
		return optional.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado") );
		
	}
	
	public Cliente atualizarCliente(Cliente cliente, Long id) {
		
		Cliente clienteOriginal = this.buscarCliente(id);
		
		cliente.setId(clienteOriginal.getId());
		
		return clienteRepository.save(cliente);
		
	}

	public void excluirCliente(Long id) {
		Cliente clienteOriginal = this.buscarCliente(id);
		
		clienteRepository.delete(clienteOriginal);
		
	}

}
