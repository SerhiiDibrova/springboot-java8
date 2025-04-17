

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table11Repository extends JpaRepository<Table11Entity, Integer> {
}