

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import hello.entity.Table4Entity;

@Repository
public interface Table4Repository extends JpaRepository<Table4Entity, Integer> {

    @Query("SELECT t FROM Table4Entity t WHERE t.id = :id")
    Table4Entity findByName(@Param("id") Integer id);
}