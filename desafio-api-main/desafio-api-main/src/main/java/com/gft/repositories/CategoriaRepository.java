package com.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String>{

}
