package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.LegacyConfig;

@Repository
public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    // Future custom query methods can be added here
}