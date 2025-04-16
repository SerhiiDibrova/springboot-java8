

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface Table5Repository extends JpaRepository<Table5, Integer> {

    @Query("SELECT t.name FROM Table5 t WHERE t.id = :id")
    Optional<String> findNameById(@Param("id") Integer id);
}