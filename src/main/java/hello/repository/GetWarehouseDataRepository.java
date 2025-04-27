package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import hello.model.TempItemsModel;
import hello.model.WarehouseDataDTO;
import java.util.List;

public interface GetWarehouseDataRepository extends JpaRepository<TempItemsModel, Long> {
    @Query("SELECT new hello.model.WarehouseDataDTO(w.warehouseId, w.warehouseName, i.inventoryCount) " +
           "FROM TempItems t " +
           "JOIN Orders o ON o.orderId = t.orderId " +
           "JOIN Inventory i ON i.orderId = o.orderId " +
           "JOIN Warehouses w ON w.warehouseId = i.warehouseId " +
           "WHERE t IN :tempItems")
    List<WarehouseDataDTO> fetchWarehouseData(List<TempItemsModel> tempItems);
}