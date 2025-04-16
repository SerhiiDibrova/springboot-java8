

package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import hello.model.Table15;

@Repository
public interface Table15Repository extends CrudRepository<Table15, Long> {
}