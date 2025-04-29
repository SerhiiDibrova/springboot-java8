package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.CustomConfig;
import java.util.Optional;

@Repository
public interface CustomConfigRepository extends JpaRepository<CustomConfig, Long> {
    Optional<CustomConfig> findByKey(String key);
    void deleteByKey(String key);
}