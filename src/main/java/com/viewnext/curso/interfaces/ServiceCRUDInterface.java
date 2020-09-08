package com.viewnext.curso.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.curso.domain.Clientes;

public interface ServiceCRUDInterface {
	
	public List<Clientes> getClientes();
	
	public Clientes postCliente(Clientes cliente);
	
	public String deleteClientePorNombre(String name);
	
	public Clientes putCliente(Clientes cliente);
}
