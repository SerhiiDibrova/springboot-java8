package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    @Query("SELECT w FROM Warehouse w WHERE w.warehouseId = ?1")
    List<Warehouse> findByWarehouseId(Integer warehouseId);

    @Lock(LockModeType.OPTIMISTIC)
    Warehouse findById(Integer id);
}