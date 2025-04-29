package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import hello.model.DisplayOptions;
import java.util.List;

@Repository
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Long> {
    
    List<DisplayOptions> findByCustomConfigId(Long customConfigId);
    
    List<DisplayOptions> findByLegacyConfigId(Long legacyConfigId);
    
    @Query("SELECT d FROM DisplayOptions d WHERE d.customConfig.id = :customConfigId AND d.legacyConfig.id = :legacyConfigId")
    List<DisplayOptions> findByCustomAndLegacyConfig(@Param("customConfigId") Long customConfigId, @Param("legacyConfigId") Long legacyConfigId);
}