package organitzacions;

import org.springframework.data.repository.CrudRepository;

import hello.Prestacions;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface OrganitzacioRepository extends CrudRepository<Prestacions, Long> {

}
