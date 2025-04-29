package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.CustomConfig;
import java.util.List;

@Repository
public interface CustomConfigRepository extends JpaRepository<CustomConfig, Long> {
    List<CustomConfig> findByOrderId(Long orderId);
    List<CustomConfig> findByConfigId(Long configId);
    List<CustomConfig> findByModule(String module);
}