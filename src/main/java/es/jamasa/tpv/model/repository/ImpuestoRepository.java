package es.jamasa.tpv.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jamasa.tpv.model.entities.Impuesto;


public interface ImpuestoRepository extends JpaRepository<Impuesto, Long>{

}
