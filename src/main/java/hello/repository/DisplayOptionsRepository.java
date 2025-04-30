package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import hello.entity.DisplayOptions;

@Repository
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Integer> {
    List<DisplayOptions> findByConfigId(Integer configId);
}