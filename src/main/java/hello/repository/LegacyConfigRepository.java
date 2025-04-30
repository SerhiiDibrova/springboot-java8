package hello.repository;

import hello.entity.LegacyConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Integer> {
    List<LegacyConfig> findByModule(String module);
}