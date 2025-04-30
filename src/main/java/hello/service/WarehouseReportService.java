package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.repository.WarehouseReportRepository;
import hello.entity.WarehouseReport;
import hello.repository.TempItemRepository;
import hello.entity.TempItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class WarehouseReportService {

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public void populateWarehouseReport() {
        String createTempTableSQL = "CREATE TABLE #WarehouseReport (warehouseId BIGINT NOT NULL, orderId BIGINT NOT NULL, inventoryLevel INT NOT NULL, warehouseName VARCHAR(255) NOT NULL)";
        entityManager.createNativeQuery(createTempTableSQL).executeUpdate();

        List<TempItem> tempItems = tempItemRepository.findAll();

        String insertSQL = "INSERT INTO #WarehouseReport (warehouseId, orderId, inventoryLevel, warehouseName) " +
                "SELECT w.WarehouseId, o.OrderId, i.InventoryLevel, w.WarehouseName " +
                "FROM #TempItems t " +
                "JOIN Orders o ON o.OrderId = t.OrderId " +
                "JOIN Inventory i ON i.OrderId = o.OrderId " +
                "JOIN Warehouses w ON w.WarehouseId = i.WarehouseId " +
                "JOIN Regions r ON r.RegionId = w.RegionId " +
                "JOIN Branches b ON b.BranchId = w.BranchId " +
                "JOIN Vendors v ON v.VendorId = o.VendorId " +
                "JOIN Products p ON p.ProductId = i.ProductId " +
                "JOIN Logistics l ON l.LogisticsId = o.LogisticsId " +
                "WHERE t.OrderId IS NOT NULL";

        try {
            entityManager.createNativeQuery(insertSQL).executeUpdate();
            String selectSQL = "SELECT * FROM #WarehouseReport";
            List<WarehouseReport> reports = entityManager.createNativeQuery(selectSQL, WarehouseReport.class).getResultList();
            warehouseReportRepository.saveAll(reports);
        } catch (Exception e) {
            // Handle exception
        }
    }
}