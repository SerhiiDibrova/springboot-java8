package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    
    @Query(value = "CREATE TABLE #WarehouseReport AS " +
                   "SELECT o.column1, i.column2, w.column3, p.column4, v.column5, b.column6, r.column7, " +
                   "l.column8, e.column9, f.column10 " +
                   "FROM Orders o " +
                   "INNER JOIN Inventory i ON o.inventory_id = i.id " +
                   "INNER JOIN Warehouses w ON i.warehouse_id = w.id " +
                   "INNER JOIN Products p ON o.product_id = p.id " +
                   "INNER JOIN Vendors v ON p.vendor_id = v.id " +
                   "INNER JOIN Branches b ON w.branch_id = b.id " +
                   "INNER JOIN Regions r ON b.region_id = r.id " +
                   "INNER JOIN Legacy_Logistics l ON o.logistics_id = l.id " +
                   "INNER JOIN Employees e ON o.employee_id = e.id " +
                   "INNER JOIN Legacy_Financials f ON o.financial_id = f.id " +
                   "WHERE <filter_conditions>", nativeQuery = true)
    void createTemporaryWarehouseReport(@Param("filter_conditions") String filterConditions);
    
    List<WarehouseReport> findAll();
}