package com.gft.services;

import com.gft.response.CepResponse;


public interface CepService {

	public CepResponse getCEP(String CEP) throws Exception;
	
}
