package com.viewnext.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.viewnext.curso.constants.ConstantPath;
import com.viewnext.curso.domain.Clientes;
import com.viewnext.curso.interfaces.ServiceCRUDInterface;

@Service
public class ServiceCRUD implements ServiceCRUDInterface {

	/*
	 * Clase encargada de la comunicación via HTTP, realiza comunicación sincrona, y
	 * ademas proporciona los metodos necesarios para la comunicacion HTTP
	 * 
	 * Si no se define ninguna instanciacion en un bean no funciona, usualmente para
	 * evitar esto se importa la libreria Spring Cloud que nos da un restTemplate
	 * configurado.
	 * 
	 * En este caso se instanciara ya que Spring Cloud no es una de las librerias
	 * que veremos en este curso.
	 */
	
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${app.url}")
	private String url;

	@Override
	public List<Clientes> getClientes() {

		ResponseEntity<List<Clientes>> response = restTemplate.exchange(url + ConstantPath.GET_PATH_CLIENTE,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Clientes>>() {
				});
		// Aqui deberiamos comprobar si fuera necesario el status code, pero como es un
		// primer ejemplo simple, ignoramos el hecho de que pueda tener status erroneos
		return response.getBody();
	}

	@Override
	public Clientes postCliente(Clientes cliente) {
		/*
		 * Cuando tenemos que enviar una peticion post, put etc, que el valor no va por
		 * el parametro si no por las cabeceras hay que declarar un objeto httpentity,
		 * ya que es la forma por la cual procesa el resttemplate nuestro objeto,
		 * tambien se suele usar cuando vamos a enviar archivos fraccionados
		 * 
		 */
		HttpEntity<Clientes> entidadEnviar = new HttpEntity<Clientes>(cliente);
		ResponseEntity<Clientes> response = restTemplate.exchange(url + ConstantPath.POST_PATH_CLIENTE, HttpMethod.POST,
				entidadEnviar, Clientes.class);
		return response.getBody();
	}

	@Override
	public String deleteClientePorNombre(String name) {
		ResponseEntity<String> response = restTemplate.exchange(
				url + ConstantPath.DELETE_PATH_CLIENTE + "?name= " + name, HttpMethod.DELETE, null, String.class);
		return response.getBody();
	}

	@Override
	public Clientes putCliente(Clientes cliente) {
		HttpEntity<Clientes> entidadEnviar = new HttpEntity<Clientes>(cliente);
		ResponseEntity<Clientes> response = restTemplate.exchange(url + ConstantPath.PUT_PATH_CLIENTE, HttpMethod.PUT,
				entidadEnviar, Clientes.class);
		return response.getBody();
	}

}
