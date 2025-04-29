package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import hello.entity.TempItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Long> {

    @Query("SELECT t FROM TempItem t WHERE t.someField = :value")
    List<TempItem> findBySomeField(@Param("value") String value);

    @PersistenceContext
    EntityManager entityManager;

    default void saveTempItem(TempItem tempItem) {
        try {
            entityManager.persist(tempItem);
        } catch (Exception e) {
            // Handle exception
        }
    }

    default void deleteTempItem(Long id) {
        try {
            TempItem tempItem = entityManager.find(TempItem.class, id);
            if (tempItem != null) {
                entityManager.remove(tempItem);
            }
        } catch (Exception e) {
            // Handle exception
        }
    }
}