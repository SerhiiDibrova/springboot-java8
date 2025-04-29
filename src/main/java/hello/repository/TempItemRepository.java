package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.TempItem;

public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    // Custom query methods can be defined here in the future
}