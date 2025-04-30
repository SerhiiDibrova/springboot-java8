package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.TempItem;
import java.util.List;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    List<TempItem> findAll();
    void deleteById(Long id);
    List<TempItem> findByOrderId(Integer orderId);
}