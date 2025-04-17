

package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import hello.entity.Proc1Entity;

public interface Proc1Repository extends CrudRepository<Proc1Entity, Integer> {
}