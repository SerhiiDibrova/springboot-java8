package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.CustomConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomConfigRepository extends JpaRepository<CustomConfig, Integer> {
    List<CustomConfig> findByModule(String module);
}