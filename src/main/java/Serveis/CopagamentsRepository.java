package Serveis;

import org.springframework.data.repository.CrudRepository;

import Serveis.Copagaments;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CopagamentsRepository extends CrudRepository<Copagaments, Long> {

}
