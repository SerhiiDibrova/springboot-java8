package hello.repository;

import hello.entity.LegacyConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {

    @Query("SELECT lc FROM LegacyConfig lc WHERE lc.active = true")
    List<LegacyConfig> findAllActive();

    @Query("SELECT lc FROM LegacyConfig lc WHERE lc.id = :id AND lc.active = true")
    LegacyConfig findActiveById(@Param("id") Long id);

    default LegacyConfig safeFindActiveById(Long id) {
        try {
            return findActiveById(id);
        } catch (Exception e) {
            // Handle exception (e.g., log the error)
            return null;
        }
    }

    default List<LegacyConfig> safeFindAllActive() {
        try {
            return findAllActive();
        } catch (Exception e) {
            // Handle exception (e.g., log the error)
            return List.of();
        }
    }
}