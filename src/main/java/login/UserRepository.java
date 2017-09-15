package login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.stereotype.Repository;

import login.User;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}