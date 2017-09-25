package org.benestar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.benestar.classes.Organitzacio;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface OrganitzacioRepository extends CrudRepository<Organitzacio, Long> {

}
