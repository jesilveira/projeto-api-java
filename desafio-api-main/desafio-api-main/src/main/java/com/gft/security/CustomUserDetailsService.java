package com.gft.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gft.entities.Roles;
import com.gft.entities.Usuarios;
import com.gft.repositories.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuarios = usuarioRepository.findByUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
		return new User(usuarios.getUsuario(), usuarios.getSenha(), mapRolesToAuthorities(usuarios.getRoles()));
				
	}
	
	private Collection<GrantedAuthority> mapRolesToAuthorities(List<Roles> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList());
	}
}
