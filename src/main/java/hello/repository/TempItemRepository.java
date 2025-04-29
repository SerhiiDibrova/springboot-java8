package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    Page<TempItem> findAll(Pageable pageable);
}