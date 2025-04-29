package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import hello.entity.TempItem;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Long>, PagingAndSortingRepository<TempItem, Long> {
}