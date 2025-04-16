

package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hello.model.Table0;

@Repository
@Transactional
public interface Table0Repository extends CrudRepository<Table0, Long> {

    void save(Table0 table0);

}