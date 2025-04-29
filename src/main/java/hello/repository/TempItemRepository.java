package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    List<TempItem> findByOrderId(Long orderId);
    List<TempItem> findAllByCustomerSegment(String customerSegment);
    List<TempItem> findByStatus(String status);
    List<TempItem> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);
    List<TempItem> findByProductId(Long productId);
}