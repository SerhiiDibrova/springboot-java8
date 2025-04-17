

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.model.Table0;

public interface Table0Repository extends JpaRepository<Table0, Integer> {

    String findByName(@Param("id") Integer id);

    Table0 save(Table0 table0);
}