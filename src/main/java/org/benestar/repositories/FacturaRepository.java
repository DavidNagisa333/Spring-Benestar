package org.benestar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.benestar.classes.Factura;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface FacturaRepository extends CrudRepository<Factura, Long> {

}