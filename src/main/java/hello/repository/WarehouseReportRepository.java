package hello.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReportRepository extends CrudRepository<WarehouseReport, Long> {

    @Modifying
    @Query(value = "INSERT INTO #WarehouseReport (column1, column2, column3) " +
                   "SELECT t.column1, o.column2, i.column3 " +
                   "FROM #TempItems t " +
                   "JOIN Orders o ON o.OrderId = t.OrderId " +
                   "JOIN Inventory i ON i.OrderId = o.OrderId " +
                   "JOIN Warehouses w ON w.WarehouseId = i.WarehouseId", nativeQuery = true)
    void insertWarehouseData();
}