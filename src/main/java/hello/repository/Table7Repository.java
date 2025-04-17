

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Table7Entity;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface Table7Repository extends JpaRepository<Table7Entity, Integer> {

    @Query("SELECT t FROM Table7Entity t WHERE t.id = :id")
    Optional<Table7Entity> findById(@Param("id") @NotNull Integer id);

    @Query("SELECT t FROM Table7Entity t WHERE t.name = :name")
    List<Table7Entity> findByName(@Param("name") String name);

    @Query("SELECT t FROM Table7Entity t WHERE t.description = :description")
    List<Table7Entity> findByDescription(@Param("description") String description);
}