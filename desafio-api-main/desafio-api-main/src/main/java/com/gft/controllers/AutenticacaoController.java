package com.gft.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gft.dto.securityDTO.CadastroDTO;
import com.gft.dto.securityDTO.LoginDTO;
import com.gft.dto.securityDTO.RespostaDeAutenticacaoDTO;
import com.gft.entities.Roles;
import com.gft.entities.Usuarios;
import com.gft.repositories.RolesRepository;
import com.gft.repositories.UsuarioRepository;
import com.gft.security.JWT;

@Controller
@RequestMapping("/v1/autenticador")
public class AutenticacaoController {

	private AuthenticationManager authenticationManager;
	private UsuarioRepository usuarioRepository;
	private RolesRepository rolesRepository;
	private PasswordEncoder passwordEncoder;
	private JWT jwt;

	@Autowired
	public AutenticacaoController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository,
			RolesRepository rolesRepository, PasswordEncoder passwordEncoder, JWT jwt) {
		this.authenticationManager = authenticationManager;
		this.usuarioRepository = usuarioRepository;
		this.rolesRepository = rolesRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwt =jwt;
	}
	
	@PostMapping("login")
	public ResponseEntity<RespostaDeAutenticacaoDTO> login(@RequestBody LoginDTO loginDTO){
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getUsuario(), loginDTO.getSenha()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwt.generateToken(authentication);
		return new ResponseEntity<>(new RespostaDeAutenticacaoDTO(token), HttpStatus.OK);
	}
	
	@PostMapping("cadastro")
	public ResponseEntity<String> cadastro(@RequestBody CadastroDTO cadastroDTO){
		if(usuarioRepository.existsByUsuario(cadastroDTO.getUsuario())){
			return new ResponseEntity<>("Nome de usuário já cadstrado", HttpStatus.BAD_REQUEST);
		}
		
		Usuarios usuarios = new Usuarios();
		usuarios.setUsuario(cadastroDTO.getUsuario());
		usuarios.setSenha(passwordEncoder.encode((cadastroDTO.getSenha())));
		
		Roles roles = rolesRepository.findByNome("usuario").get();	
		usuarios.setRoles(Collections.singletonList(roles));
		
		usuarioRepository.save(usuarios);
		
		return new ResponseEntity<>("Cadastro realizado com sucesso!", HttpStatus.OK);
	}

}