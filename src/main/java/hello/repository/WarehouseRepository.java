package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
import hello.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByWarehouseId(Long warehouseId);
    
    List<Warehouse> findAll();
    
    Optional<Warehouse> findById(Long id);
    
    Warehouse save(Warehouse warehouse);
    
    void deleteById(Long id);
    
    @Query("SELECT w FROM Warehouse w WHERE w.warehouseCapacity >= :capacity")
    List<Warehouse> findByCapacityGreaterThanEqual(@Param("capacity") Integer capacity);
}