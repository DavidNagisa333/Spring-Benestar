package org.benestar.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.benestar.classes.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long>{}
