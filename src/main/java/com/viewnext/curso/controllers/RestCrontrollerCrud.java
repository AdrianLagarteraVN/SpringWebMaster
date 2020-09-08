package com.viewnext.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.curso.domain.Clientes;
import com.viewnext.curso.interfaces.RestControllerCRUDInterface;
import com.viewnext.curso.interfaces.ServiceCRUDInterface;

@RestController()
public class RestCrontrollerCrud implements RestControllerCRUDInterface {

	/*
	 * Aunque declaramos la interfaz del servicio, Spring busca la clase que
	 * implemente el mismo, si no existiera crearia el uno, que no haria
	 * absolutamente nada
	 * 
	 * Si dispusieramos de mas de una clase que extendiera del mismo servicio habria
	 * que priorizar cual debe inyectarse, o spring nos daria un error, En este
	 * proyecto no se vera como se hace, se podra ver en el proyecto:
	 */

	@Autowired
	private ServiceCRUDInterface servicio;

	@Override
	public ResponseEntity<List<Clientes>> getClientes() {
		List<Clientes> listaClientes = servicio.getClientes();
		ResponseEntity<List<Clientes>> response = new ResponseEntity<List<Clientes>>(listaClientes, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<Clientes> postCliente(Clientes cliente) {
		//No gestionamos los errores en este proyecto
		Clientes clienteInsertado = servicio.postCliente(cliente);
		ResponseEntity<Clientes> response = new ResponseEntity<Clientes>(clienteInsertado, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<String> peticionDelete(String nombre) {
		String respuesta = servicio.deleteClientePorNombre(nombre);
		ResponseEntity<String> response = new ResponseEntity<String>(respuesta, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<Clientes> peticionPut(Clientes cliente) {
		Clientes clienteActualizado = servicio.putCliente(cliente);
		ResponseEntity<Clientes> response = new ResponseEntity<Clientes>(clienteActualizado, HttpStatus.OK);
		return response;
	}

}
