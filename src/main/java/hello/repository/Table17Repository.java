

package hello.repository;

import hello.entity.Table17Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table17Repository extends JpaRepository<Table17Entity, Integer> {
}