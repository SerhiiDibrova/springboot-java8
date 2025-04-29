package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TempItemRepository extends JpaRepository<TempItem, Integer> {
    
    List<TempItem> findByOrderId(Integer orderId);
    
    @Query("SELECT t FROM TempItem t WHERE t.someField = :someValue")
    List<TempItem> findBySomeField(@Param("someValue") String someValue);
    
    void deleteById(Integer id);
}