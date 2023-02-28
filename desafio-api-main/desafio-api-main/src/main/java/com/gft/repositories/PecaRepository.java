package com.gft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.entities.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {

	Page<Peca> findAll(Pageable pageable);

	Page<Peca> findAllByCategoria_Nome(String categoria, Pageable pageable);

	List<Peca> findAllByCategoria_Nome(String categoria);

	Page<Peca> findAllByFornecedor_Cnpj(String cnpj, Pageable pageable);

	@Transactional
	List<Peca> deleteAllByFornecedor_Cnpj(String cnpj);

	@Transactional
	List<Peca> deleteAllByCategoria_Nome(String categoria);

	@Query(value = "SELECT SUM(valor_total) as ValorTotalEstoque FROM desafio_api.tb_peca", nativeQuery = true)
	double findByValorTotal();

}
