package hello.repository;

import hello.entity.CustomConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomConfigRepository extends JpaRepository<CustomConfig, Long> {
    // Additional query methods can be defined here if needed
}