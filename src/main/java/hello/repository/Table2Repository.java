

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table2Repository extends CrudRepository<Table2Entity, Integer> {
}