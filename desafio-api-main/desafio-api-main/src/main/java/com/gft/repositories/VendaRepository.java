package com.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
