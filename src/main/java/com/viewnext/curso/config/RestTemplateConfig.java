package com.viewnext.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	/*
	 * Configuracion minima para que funcione nuestro restTemplate en cualquier
	 * parte del microservicio.
	 */

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
