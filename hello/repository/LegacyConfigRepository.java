package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.LegacyConfig;

public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
}