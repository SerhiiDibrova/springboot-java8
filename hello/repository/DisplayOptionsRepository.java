package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Integer> {
    List<DisplayOptions> findByModule(String module);
}