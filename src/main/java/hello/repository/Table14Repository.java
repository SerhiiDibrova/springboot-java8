

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hello.entity.Table14Entity;

@Repository
public interface Table14Repository extends JpaRepository<Table14Entity, Integer> {

    @Modifying
    @Transactional
    @Query("INSERT INTO table_14 (column1, column2, column3) VALUES (:column1, :column2, :column3)")
    void saveTable14ByColumn1AndColumn2AndColumn3(@Param("column1") String column1, @Param("column2") String column2, @Param("column3") String column3);

}