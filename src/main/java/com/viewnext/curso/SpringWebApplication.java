package com.viewnext.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * En este proyecto crearemos un webapp, no dispondra de front ya que lo que nos
 * interesa son las peticiones back, y comunicarnos con otro microservicio. Este
 * micro actuara de master es decir todas las peticiones iran desde este
 * microservicio a los demas que seran denominados nodos.
 * 
 * @author 0016382
 *
 */
@SpringBootApplication
public class SpringWebApplication {

    //Nos vemos mañana
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

}
