package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.DisplayOptions;

public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Long> {
    // Additional custom query methods can be defined here if needed
}