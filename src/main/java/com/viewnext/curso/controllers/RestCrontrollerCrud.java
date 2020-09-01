package com.viewnext.curso.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.curso.interfaces.RestControllerCRUDInterface;

@RestController
public class RestCrontrollerCrud implements RestControllerCRUDInterface{

	@Override
	public ResponseEntity<String> peticionGet(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> peticionPost(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> peticionDelete(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> peticionPut(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
