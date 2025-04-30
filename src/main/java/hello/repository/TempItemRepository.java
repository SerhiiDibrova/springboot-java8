package hello.repository;

import hello.entity.TempItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    List<TempItem> findAll();

    @Query("SELECT t FROM TempItem t WHERE t.orderId = ?1")
    List<TempItem> findByOrderId(Long orderId);

    Page<TempItem> findAll(Pageable pageable);
}