

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.entity.Table6Entity;

@Repository
public interface Table6Repository extends JpaRepository<Table6Entity, Long> {

    Table6Entity findById(Long id);
}