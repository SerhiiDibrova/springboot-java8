package hello.repository;

import hello.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByOrderId(Integer orderId);
    List<Inventory> findByStockLevel(int stockLevel);
}