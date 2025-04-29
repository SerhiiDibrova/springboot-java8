package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.entity.LegacyConfig;
import java.util.List;

public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    
    @Query("SELECT lc FROM LegacyConfig lc WHERE lc.module IN :modules")
    List<LegacyConfig> findByModules(@Param("modules") List<String> modules);
    
    @Query("SELECT lc FROM LegacyConfig lc WHERE lc.active = true")
    List<LegacyConfig> findActiveConfigs();
}