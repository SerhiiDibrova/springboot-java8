package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    List<LegacyConfig> findByModule(String module);
    
    default List<LegacyConfig> findByModuleWithErrorHandling(String module) {
        try {
            List<LegacyConfig> configs = findByModule(module);
            if (configs.isEmpty()) {
                throw new RuntimeException("No records found for module: " + module);
            }
            return configs;
        } catch (Exception e) {
            throw new RuntimeException("Database access error: " + e.getMessage(), e);
        }
    }
}