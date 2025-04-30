package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import java.util.List;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Integer> {
    
    @Query("SELECT t FROM TempItem t WHERE t.orderId = ?1")
    List<TempItem> findByOrderId(Integer orderId);
    
    default TempItem saveTempItem(TempItem tempItem) {
        try {
            return save(tempItem);
        } catch (DataAccessException e) {
            // Handle exception (e.g., log the error)
            throw e;
        }
    }
}