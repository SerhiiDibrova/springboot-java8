

package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface Table5Repository extends JpaRepository<Table5, Integer> {
    List<Table5> findByName(String name);
}