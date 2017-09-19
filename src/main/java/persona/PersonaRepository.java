package persona;

import org.springframework.data.repository.CrudRepository;

import hello.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long>{
	
	Iterable<Persona> findById(Long id);
	Iterable<Persona> findByNom(String nom);
	Iterable<Persona> findByCognoms(String cognoms);
	Iterable<Persona> findByCorreu(String correu);
	Iterable<Persona> findByTelefon(String telefon);
	Iterable<Persona> findByMobil(String mobil);
	Iterable<Persona> findByAdreca(String adreca);
	Iterable<Persona> findByLocalitat(String localitat);
	Iterable<Persona> findByComarca(String comarca);
}
