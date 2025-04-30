package hello.repository;

import hello.entity.CustomConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph;
import javax.persistence.LockModeType;
import java.util.List;

public interface CustomConfigRepository extends JpaRepository<CustomConfig, Integer> {
    List<CustomConfig> findByOrderId(Integer orderId);

    @Lock(LockModeType.OPTIMISTIC)
    @EntityGraph(attributePaths = {"relatedEntity"})
    @Query("SELECT c FROM CustomConfig c WHERE c.orderId = ?1")
    List<CustomConfig> findWithLockByOrderId(Integer orderId);
}