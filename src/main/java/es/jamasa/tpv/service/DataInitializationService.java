package es.jamasa.tpv.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.jamasa.tpv.model.entities.Rol;
import es.jamasa.tpv.model.entities.Usuario;
import es.jamasa.tpv.model.repository.RolRepository;
import es.jamasa.tpv.model.repository.UsuarioRepository;
/**
 * 
 * Clase {@code @Service} de inicialización de datos para las pruebas.
 * 
 * <p> Se genera 
 * 
 * <p>Comprueba si existe un dato y lo inserta.
 *  <ul>
* <li>Tabla de ROLES de usuario</li>
* <li>Tabla de USUARIOS</li>
* 
* </ul>
*
*/
@Service
public class DataInitializationService {
	RolRepository rolRepo;
	UsuarioRepository userRepo; 
	PasswordEncoder passEncoder;
	
	
	public DataInitializationService(RolRepository rolRepo,
		UsuarioRepository userRepo, 
		PasswordEncoder passEncoder) {
		
		this.rolRepo= rolRepo ;
		this.userRepo = userRepo; 
		this.passEncoder = passEncoder;
	}
	
	@Transactional 
    public void cargarDatos() {
		if (rolRepo.count() == 0) {
			rolRepo.save(new Rol("ADMIN", "Rol de Administrador"));
			rolRepo.save(new Rol("VENDE", "Rol de Vendedor"));
			
		}
		if (userRepo.findByEmail("admin@correo.es").isEmpty()) {
			userRepo.save(new Usuario("admin", "admin@correo.es", "number", "one", passEncoder.encode("admin@correo.es")  , "ADMIN", true, LocalDateTime.now(), "CARGA INICIAL"));
			
		}

		System.out.println("--------------------------------------------");
		System.out.println("----------FIN DE CARGA DE DATOS-------------");
		System.out.println("--------------------------------------------");
    }
}
