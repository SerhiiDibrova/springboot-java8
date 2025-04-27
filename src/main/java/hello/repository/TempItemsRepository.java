package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.TempItems;

public interface TempItemsRepository extends JpaRepository<TempItems, Long> {
}