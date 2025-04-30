package hello.repository;

import hello.entity.DisplayOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Repository
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Integer> {
    
    @Query("SELECT d FROM DisplayOptions d WHERE d.configId = :configId")
    default List<DisplayOptions> findByConfigId(Integer configId) {
        List<DisplayOptions> displayOptions = findByConfigIdInternal(configId);
        if (displayOptions.isEmpty()) {
            return Collections.emptyList();
        }
        return displayOptions;
    }

    @Query("SELECT d FROM DisplayOptions d WHERE d.configId = :configId")
    List<DisplayOptions> findByConfigIdInternal(Integer configId);
}