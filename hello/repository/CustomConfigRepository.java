package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.CustomConfig;

public interface CustomConfigRepository extends JpaRepository<CustomConfig, Long> {
    CustomConfig findByKey(String key);
    void deleteByKey(String key);
}