package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    List<LegacyConfig> findByOrderIdAndModule(Long orderId, String module);
}