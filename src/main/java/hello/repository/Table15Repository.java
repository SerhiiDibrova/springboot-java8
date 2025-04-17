

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Repository
@Validated
public interface Table15Repository extends JpaRepository<Table15Entity, Integer> {

    @Query("SELECT t FROM Table15Entity t WHERE t.id = :id")
    Optional<Table15Entity> findById(@Param("id") Integer id);

    @Query("SELECT t FROM Table15Entity t WHERE t.name = :name")
    List<Table15Entity> findByName(@Param("name") String name);

    @Query("SELECT t FROM Table15Entity t WHERE t.description = :description")
    List<Table15Entity> findByDescription(@Param("description") String description);

    @Query("SELECT t FROM Table15Entity t WHERE t.status = :status")
    List<Table15Entity> findByStatus(@Param("status") String status);

    default Table15Entity save(@Valid Table15Entity entity) {
        return save(entity, null);
    }

    default Table15Entity save(@Valid Table15Entity entity, String username) {
        // implement save logic with optional username parameter
        return entity;
    }

    default void deleteById(Integer id) {
        deleteById(id, null);
    }

    default void deleteById(Integer id, String username) {
        // implement delete logic with optional username parameter
    }

    default List<Table15Entity> findAll() {
        return findAll(null);
    }

    default List<Table15Entity> findAll(String username) {
        // implement find all logic with optional username parameter
        return new ArrayList<>();
    }
}