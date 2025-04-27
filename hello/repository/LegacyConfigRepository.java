package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.LegacyConfig;

/**
 * Repository interface for LegacyConfig entity.
 * Provides CRUD operations and can be extended for custom queries.
 */
public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    // Additional custom query methods can be defined here
}