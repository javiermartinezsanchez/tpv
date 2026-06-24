package es.jamasa.tpv.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import es.jamasa.tpv.model.entities.Usuario;
/**
 * Repositorio entidad Usuario.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>{

	/**
	 * Obtenemos un Usuario de acuerdo al e-mail (usuario) solicitado
	 * @param email Email que se busca.
	 * @return El Usuario encontrado o no {@link Optional}
	 */
	public Optional<Usuario> findByEmail(String email);
}
