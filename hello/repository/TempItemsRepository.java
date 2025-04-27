package hello.repository;

import hello.model.TempItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempItemsRepository extends JpaRepository<TempItems, Long> {
}