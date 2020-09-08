package com.viewnext.curso.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Esta clase corresponde al paquete datos del microservicio WebNodoCliente
 * Siempre hay que tener la clase de los objetos que queremos que nos lleguen para que 
 * Jackson lo paresee y nos lo deje utilizable
 * 
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {

	private Long id;

	private String nombreCliente;
	private String telefonoCliente;
	private String fechaRegistroCliente;
	private String correoCliente;
}
