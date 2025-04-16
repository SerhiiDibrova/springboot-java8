

package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.entity.Proc39Record;

@Repository
public interface Proc39Repository extends CrudRepository<Proc39Record, Long> {
}