

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Table10Repository extends JpaRepository<Table10Entity, Integer> {

    @Query("SELECT t FROM Table10Entity t WHERE t.column1 = ?1")
    Table10Entity findByColumn1(String column1);

    @Query("SELECT t FROM Table10Entity t WHERE t.column2 = ?1")
    Table10Entity findByColumn2(String column2);

    @Query("SELECT t FROM Table10Entity t WHERE t.column1 = ?1 AND t.column2 = ?2")
    Table10Entity findByColumn1AndColumn2(String column1, String column2);

}