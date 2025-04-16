

package hello.repository;

import hello.model.Table6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Table6Repository extends JpaRepository<Table6, Long> {

    @Modifying
    @Query("INSERT INTO Table6 (id, column1, column2, column3, column4, column5) VALUES (:id, :column1, :column2, :column3, :column4, :column5)")
    void insert(@Param("id") Long id, @Param("column1") String column1, @Param("column2") String column2, @Param("column3") String column3, @Param("column4") String column4, @Param("column5") String column5);

    Optional<Table6> findByColumn1(String column1);

    Optional<Table6> findByColumn2(String column2);

    Optional<Table6> findByColumn3(String column3);

    Optional<Table6> findByColumn4(String column4);

    Optional<Table6> findByColumn5(String column5);

}