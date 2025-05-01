package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.DisplayOptions;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Integer> {
    List<DisplayOptions> findByConfigId(Integer configId);
}