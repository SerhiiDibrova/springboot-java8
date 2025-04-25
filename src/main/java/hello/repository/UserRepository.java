package hello.repository;

import hello.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u")
    List<User> findAll(@Param("limit") int limit, @Param("offset") int offset);

    default Optional<User> getById(int id) {
        return findAll().stream().filter(user -> user.getId() == id).findFirst();
    }
}