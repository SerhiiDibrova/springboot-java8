package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Long> {
    Logger logger = LoggerFactory.getLogger(DisplayOptionsRepository.class);

    @Query("SELECT d FROM DisplayOptions d WHERE d.configId IN :configIds")
    default List<DisplayOptions> findByConfigIds(@Param("configIds") List<Long> configIds) {
        try {
            return findByConfigIdsInternal(configIds);
        } catch (Exception e) {
            logger.error("Error retrieving display options for config IDs: {}", configIds, e);
            throw e;
        }
    }

    @Query("SELECT d FROM DisplayOptions d WHERE d.configId IN :configIds")
    List<DisplayOptions> findByConfigIdsInternal(@Param("configIds") List<Long> configIds);
}