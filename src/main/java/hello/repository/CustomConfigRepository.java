package hello.repository;

import hello.entity.CustomConfig;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomConfigRepository extends PagingAndSortingRepository<CustomConfig, Long> {
    List<CustomConfig> findByOrderIdAndModule(Long orderId, String module);
}