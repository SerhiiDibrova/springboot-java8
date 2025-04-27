package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.LegacyConfig;

public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    LegacyConfig findByName(String name);
    List<LegacyConfig> findByActive(boolean active);
}