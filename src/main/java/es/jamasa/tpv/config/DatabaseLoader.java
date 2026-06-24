package es.jamasa.tpv.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.jamasa.tpv.service.DataInitializationService;

/**
 * Clase inicial en la que se llama al Servicio de carga de datos {@link DataInitializationService}.
 * 
 */
@Configuration
public class DatabaseLoader {
	
	/**
	 *   Generamos los datos de Roles y usuarios básicos (admin, profe1, estudiante1).
	 */
	@Bean
	public CommandLineRunner initializeDatabase(
			DataInitializationService initService) {
	    return args -> {
	        initService.cargarDatos();
	    };
	}
	

}
