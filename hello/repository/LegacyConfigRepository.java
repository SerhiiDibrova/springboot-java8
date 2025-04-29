package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import hello.entity.LegacyConfig;

import java.util.Optional;

@Repository
public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    
    Optional<LegacyConfig> findByKey(String key);
    
    @Query("SELECT lc FROM LegacyConfig lc WHERE lc.value = :value")
    Optional<LegacyConfig> findByValue(@Param("value") String value);
    
    void deleteByKey(String key);
}