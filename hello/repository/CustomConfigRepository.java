package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.CustomConfig;

public interface CustomConfigRepository extends JpaRepository<CustomConfig, Long> {
}