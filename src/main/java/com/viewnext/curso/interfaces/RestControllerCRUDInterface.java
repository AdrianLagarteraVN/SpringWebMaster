package com.viewnext.curso.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.viewnext.curso.constants.ConstantPath;
import com.viewnext.curso.domain.Clientes;

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
@RequestMapping(value = ConstantPath.BASE_PATH)
public interface RestControllerCRUDInterface {

	/*
	 * Se usa principalmente cuando los datos van en la cabecera, eso quiere decir,
	 * datos no sensibles, por ejemplo en una pagina el referido siempre suele ir en
	 * la url, se asemeja a un SELECT de base de datos. Nunca se debe usar para
	 * insertar datos. No permite el uso de payloads
	 */
	@GetMapping(ConstantPath.GET_PATH_MASTER_CLIENTE)
	ResponseEntity<List<Clientes>> getClientes();

	/*
	 * Se usa principalmente cuando se usan datos sensibles, ya que el usuario
	 * estandar no puede modificar estos datos y no son visibles en la cabecera. Por
	 * ejemplo la contraseña, el telefono la direccion etc etc. Se asemeja a un
	 * INSERT de base de datos. No deberia usarse para extraer informacion y
	 * mostrarla. Permite el uso de payloads.
	 */
	@PostMapping(ConstantPath.POST_PATH_MASTER_CLIENTE)
	ResponseEntity<Clientes> postCliente(@RequestBody Clientes cliente);

	/*
	 * Se utiliza para mandar peticiones de borrado, puede que no se mande ningun
	 * parametro y sea simplemente por url, aqui vamos a mandar por parametro. Se
	 * asemeja a la accion DELETE de base de datos
	 */
	@DeleteMapping(ConstantPath.DELETE_PATH_MASTER_CLIENTE)
	ResponseEntity<String> peticionDelete(@RequestParam String nombre);

	/*
	 * Se utiliza para mandar peticiones de actualizacion de todo un registro, se
	 * asemeja a la accion UPDATE de base de datos. Acepta el uso de payloads.
	 */

	@PutMapping(ConstantPath.PUT_PATH_MASTER_CLIENTE)
	ResponseEntity<Clientes> peticionPut(@RequestBody Clientes cliente);

}
