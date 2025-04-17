

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Table16Entity;

@Repository
public interface Table16Repository extends JpaRepository<Table16Entity, Long> {

    @Modifying
    @Query("INSERT INTO table_16 (column1, column2, column3) VALUES (:column1, :column2, :column3)")
    void insertRecord(@Param("column1") String column1, @Param("column2") String column2, @Param("column3") String column3);
}