package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Integer> {
    @Transactional
    TempItem save(TempItem tempItem);
    
    @Transactional
    void deleteById(Integer id);
    
    @Transactional(readOnly = true)
    TempItem findById(Integer id);
    
    @Transactional(readOnly = true)
    List<TempItem> findByOrderId(Integer orderId);
    
    @Transactional(readOnly = true)
    List<TempItem> findByConfigId(Integer configId);
    
    @Transactional(readOnly = true)
    List<TempItem> findByCustomerSegment(String customerSegment);
}