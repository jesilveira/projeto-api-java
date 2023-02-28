package com.gft.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JWT tokenGenerator;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = getJWTFromRequest(request);
		if(StringUtils.hasText(token) && tokenGenerator.validarToken(token)) {
			String usuario = tokenGenerator.getUsuarioJWT(token);
			
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(usuario);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					usuario, userDetails.getAuthorities(), null);
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		filterChain.doFilter(request, response);
	}

	private String getJWTFromRequest(HttpServletRequest request) {

		String BearerToken = request.getHeader("Autorization");
		if(StringUtils.hasText(BearerToken) && BearerToken.startsWith("Bearer ")) {
			return BearerToken.substring(7, BearerToken.length());
		}
		
		return null;
	}
	
	

}
