

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import hello.entity.Table8Entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Repository for Table8Entity.
 */
@Repository
public interface Table8Repository extends JpaRepository<Table8Entity, Integer> {

    /**
     * Finds all Table8Entity instances.
     *
     * @return List of Table8Entity instances.
     */
    @Override
    List<Table8Entity> findAll();

    /**
     * Finds a Table8Entity instance by id.
     *
     * @param id the id of the instance to find.
     * @return Optional of Table8Entity instance.
     */
    @Override
    Optional<Table8Entity> findById(Integer id);

    /**
     * Saves a Table8Entity instance.
     *
     * @param entity the instance to save.
     * @return the saved instance.
     */
    @Override
    @Valid
    Table8Entity save(@NotNull Table8Entity entity);

    /**
     * Deletes a Table8Entity instance by id.
     *
     * @param id the id of the instance to delete.
     */
    @Override
    void deleteById(Integer id);

    /**
     * Custom query to find Table8Entity instances by name.
     *
     * @param name the name to search for.
     * @return List of Table8Entity instances.
     */
    @Query("SELECT t FROM Table8Entity t WHERE t.name = :name")
    List<Table8Entity> findByName(@Param("name") String name);

    /**
     * Custom query to find Table8Entity instances by name and description.
     *
     * @param name        the name to search for.
     * @param description the description to search for.
     * @return List of Table8Entity instances.
     */
    @Query("SELECT t FROM Table8Entity t WHERE t.name = :name AND t.description = :description")
    List<Table8Entity> findByNameAndDescription(@Param("name") String name, @Param("description") String description);
}