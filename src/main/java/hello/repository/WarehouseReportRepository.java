package hello.repository;

import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    
    @Modifying
    @Query(value = "INSERT INTO WarehouseReport (field1, field2, field3, field4, field5, field6, field7, field8, field9, field10) " +
                   "SELECT o.field1, i.field2, w.field3, p.field4, v.field5, b.field6, r.field7, l.field8, e.field9, f.field10 " +
                   "FROM Orders o " +
                   "INNER JOIN Inventory i ON o.inventory_id = i.id " +
                   "INNER JOIN Warehouses w ON i.warehouse_id = w.id " +
                   "INNER JOIN Products p ON i.product_id = p.id " +
                   "INNER JOIN Vendors v ON p.vendor_id = v.id " +
                   "INNER JOIN Branches b ON w.branch_id = b.id " +
                   "INNER JOIN Regions r ON b.region_id = r.id " +
                   "INNER JOIN Logistics l ON o.logistics_id = l.id " +
                   "INNER JOIN Employees e ON o.employee_id = e.id " +
                   "INNER JOIN Financials f ON o.financial_id = f.id " +
                   "INNER JOIN TempItems t ON o.temp_item_id = t.id " +
                   "WHERE t.condition = :condition", nativeQuery = true)
    void populateWarehouseReport(String condition);
}