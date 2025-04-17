

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Table9Entity;

@Repository
public interface Table9Repository extends JpaRepository<Table9Entity, Integer> {

    @Query("SELECT t FROM Table9Entity t WHERE t.id = :id")
    Table9Entity findById(@Param("id") Integer id);
}