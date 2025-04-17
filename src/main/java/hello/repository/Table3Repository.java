

package hello.repository;

import hello.entity.Table3Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface Table3Repository extends JpaRepository<Table3Entity, Integer> {

    Table3Entity findById(Integer id);

    List<Table3Entity> findByCreatedAtAfter(Date date);

    Table3Entity save(Table3Entity entity);
}