package com.gft.consumoapiexterna.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gft.response.CepResponse;
import com.gft.services.CepService;

@Service
@Transactional
public class CepServiceImpl implements CepService{

	@Override
	public CepResponse getCEP(String CEP) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		String URLAPI = "https://viacep.com.br/ws/"+CEP+"/json/";
		
		CepResponse response = restTemplate.getForObject(URLAPI, CepResponse.class);

		return response;
	}
}
