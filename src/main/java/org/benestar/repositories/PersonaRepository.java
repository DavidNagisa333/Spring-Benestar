package org.benestar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.benestar.classes.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long>{
	/*
	Iterable<Persona> findById(Long id);
	Iterable<Persona> findByNom(String nom);
	Iterable<Persona> findByCognoms(String cognoms);
	Iterable<Persona> findByCorreu(String correu);
	Iterable<Persona> findByTelefon(String telefon);
	Iterable<Persona> findByMobil(String mobil);
	Iterable<Persona> findByAdreca(String adreca);
	Iterable<Persona> findByLocalitat(String localitat);
	Iterable<Persona> findByComarca(String comarca);*/
}
