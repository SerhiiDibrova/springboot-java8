package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.LegacyConfig;
import java.util.List;

public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Integer> {
    List<LegacyConfig> findByModule(String module);
}