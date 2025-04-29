package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.TempItem;
import java.util.List;

public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    List<TempItem> findByName(String name);
    List<TempItem> findByCategory(String category);
}