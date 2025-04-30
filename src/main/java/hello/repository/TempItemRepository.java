package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.TempItem;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    List<TempItem> findByOrderId(Long orderId);
    
    // Custom query methods for retrieving display options can be added here
}