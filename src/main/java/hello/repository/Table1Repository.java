

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Table1Entity;

@Repository
public interface Table1Repository extends JpaRepository<Table1Entity, Integer> {

    @Query("SELECT t FROM Table1Entity t WHERE t.column1 = :column1")
    Table1Entity findByColumn1(@Param("column1") String column1);

    @Query("SELECT t FROM Table1Entity t WHERE t.column2 = :column2")
    Table1Entity findByColumn2(@Param("column2") String column2);

}