package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.entity.TempItem;
import java.util.List;

public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    
    List<TempItem> findByStatus(String status);
    
    @Query("SELECT t FROM TempItem t WHERE t.category = :category")
    List<TempItem> findByCategory(@Param("category") String category);
    
    @Query("SELECT t FROM TempItem t WHERE t.createdDate BETWEEN :startDate AND :endDate")
    List<TempItem> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}