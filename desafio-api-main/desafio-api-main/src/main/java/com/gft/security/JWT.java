package com.gft.security;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWT {

	public String generateToken(Authentication authentication) {
		String usuario = authentication.getName();
		Date dataInicio = new Date();
		Date dataExpiracao = new Date(dataInicio.getTime() + SecurityConstantes.JWTExpiracao);
		
		String token = Jwts.builder()
				.setSubject(usuario)
				.setIssuedAt(new Date())
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS512, SecurityConstantes.JWTSecret)
				.compact();
		return token;
	}
	
	public String getUsuarioJWT (String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(SecurityConstantes.JWTSecret)
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	public boolean validarToken(String token) {
		try {
			
			Jwts.parser().setSigningKey(SecurityConstantes.JWTSecret).parseClaimsJws(token);
			return true;
		}catch(Exception ex) {
			throw new AuthenticationCredentialsNotFoundException("JWT expirado ou incorreto");
		}
	}
	
}
