package com.viewnext.curso.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Se crea una interfaz en la que declaramos nuestros metodos para luego
 * implementarlos. Esto se hace sobre todo cuando tenemos diferentes perfiles y
 * queremos diferentes comportamientos en cada entorno. Por ejemplo en local
 * puede que queramos diferentes puertos pero en dev todos el mismo
 * 
 * Como ademas ya sabemos que vamos a crear las cuatro peticiones mas clasicas
 * no tendremos que tocar mas esta clase.
 * 
 * @author 0016382
 *
 */

public interface RestControllerCRUDInterface {

	/*
	 * Se usa principalmente cuando los datos van en la cabecera, eso quiere decir,
	 * datos no sensibles, por ejemplo en una pagina el referido siempre suele ir en
	 * la url a veces como parte de la direccion o como parametro de la peticion get
	 */
	@GetMapping(name = "getName")
	ResponseEntity<String> peticionGet(String nombre);

	/*
	 * Se usa principalmente cuando se usan datos sensibles, ya que el usuario
	 * estandar no puede modificar estos datos y no son visibles en la cabecera. Por
	 * ejemplo la contraseña, el telefono la direccion etc etc.
	 */
	@PostMapping(name = "postName")
	ResponseEntity<String> peticionPost(String nombre);

	/* Se utiliza para mandar peticiones de borrado, puede que no sea*/
	@DeleteMapping(name = "deleteName")
	ResponseEntity<String> peticionDelete(String nombre);

	@PutMapping(name = "putName")
	ResponseEntity<String> peticionPut(String nombre);

}
