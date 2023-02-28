package com.gft.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.entities.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

	Optional<Usuarios> findByUsuario(String usuario);

	Boolean existsByUsuario(String usuario);

}