

package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.entity.Table14Record;

@Repository
public interface Table14Repository extends CrudRepository<Table14Record, Long> {

}