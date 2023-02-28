package com.gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

	Page<Fornecedor> findAll(Pageable pageable);
}
