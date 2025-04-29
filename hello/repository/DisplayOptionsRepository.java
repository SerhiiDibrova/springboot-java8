package hello.repository;

import hello.entity.DisplayOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Long> {
    
    @Query("SELECT d FROM DisplayOptions d WHERE d.configId IN (SELECT c.id FROM CustomConfig c WHERE c.someCondition = :condition)")
    List<DisplayOptions> findByCustomConfigCondition(@Param("condition") String condition);
    
    @Query("SELECT d FROM DisplayOptions d WHERE d.configId IN (SELECT l.id FROM LegacyConfig l WHERE l.someCondition = :condition)")
    List<DisplayOptions> findByLegacyConfigCondition(@Param("condition") String condition);
}