

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Table18Entity;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface Table18Repository extends JpaRepository<Table18Entity, Integer> {

    @Query("SELECT t FROM Table18Entity t WHERE t.id = :id")
    Optional<Table18Entity> findById(@Param("id") @NotNull Integer id);

    @Query("SELECT t FROM Table18Entity t WHERE t.name = :name")
    List<Table18Entity> findByName(@Param("name") @NotNull String name);
}