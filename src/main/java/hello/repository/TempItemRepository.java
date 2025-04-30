package hello.repository;

import hello.entity.TempItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TempItemRepository extends JpaRepository<TempItem, Long> {
}