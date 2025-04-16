

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.Table9;

@Repository
public interface Table9Repository extends JpaRepository<Table9, Long> {
    Table9 findByName(String name);
}