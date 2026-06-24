package es.jamasa.tpv.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jamasa.tpv.model.entities.Moneda;

public interface MonedaRepository extends JpaRepository<Moneda, Long>{

	
}
