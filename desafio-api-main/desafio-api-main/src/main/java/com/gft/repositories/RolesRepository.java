package com.gft.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByNome(String nome);
}