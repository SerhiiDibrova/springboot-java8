package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface WarehouseDataRepository extends JpaRepository<WarehouseData, Long> {
    
    @Query("SELECT wd FROM WarehouseData wd JOIN wd.orders o JOIN wd.inventory i JOIN wd.warehouses w WHERE o.tempItem IN :tempItems")
    List<WarehouseData> findByTempItems(@Param("tempItems") List<TempItemDTO> tempItems);
}