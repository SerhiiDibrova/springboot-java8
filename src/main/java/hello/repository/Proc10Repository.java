

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface Proc10Repository extends JpaRepository<Proc10Entity, Integer> {

    Proc10Entity save(Proc10Entity entity);
}