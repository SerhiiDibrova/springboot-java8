package hello.repository;

import hello.entity.TempItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    List<TempItem> findByStatus(String status);

    @Query("SELECT t FROM TempItem t WHERE t.createdDate >= :startDate AND t.createdDate <= :endDate")
    List<TempItem> findByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}