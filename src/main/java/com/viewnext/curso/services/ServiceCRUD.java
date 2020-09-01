package com.viewnext.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.viewnext.curso.interfaces.ServiceCRUDInterface;

public class ServiceCRUD implements ServiceCRUDInterface {

	/*
	 * Clase encargada de la comunicación via HTTP, realiza comunicación sincrona, y
	 * ademas proporciona los metodos necesarios para la comunicacion HTTP
	 */
	@Autowired
	private RestTemplate restTemplate;

	@Value("${app.url}")
	private String url;

	@Override
	public String getName() {
		
		
		restTemplate.exchange(url, HttpMethod.GET, null, String.class)
		return null;
	}

	@Override
	public String postName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String putName() {
		// TODO Auto-generated method stub
		return null;
	}

}
