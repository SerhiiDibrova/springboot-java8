package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Integer> {
    @Query("SELECT d FROM DisplayOptions d WHERE d.orderId = ?1")
    List<DisplayOptions> findByOrderId(Integer orderId);

    @Lock(LockModeType.OPTIMISTIC)
    @EntityGraph(attributePaths = {"relatedEntity"})
    List<DisplayOptions> findWithOptimisticLockByOrderId(Integer orderId);
}