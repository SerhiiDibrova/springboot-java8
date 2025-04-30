package hello.service;

import hello.repository.TempItemRepository;
import hello.repository.WarehouseReportRepository;
import hello.repository.OrderRepository;
import hello.repository.InventoryRepository;
import hello.repository.WarehouseRepository;
import hello.model.TempItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class WarehouseReportService {

    private final TempItemRepository tempItemRepository;
    private final WarehouseReportRepository warehouseReportRepository;
    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseReportService(TempItemRepository tempItemRepository,
                                  WarehouseReportRepository warehouseReportRepository,
                                  OrderRepository orderRepository,
                                  InventoryRepository inventoryRepository,
                                  WarehouseRepository warehouseRepository) {
        this.tempItemRepository = tempItemRepository;
        this.warehouseReportRepository = warehouseReportRepository;
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @Transactional
    public void generateWarehouseReport() {
        try (Connection connection = warehouseReportRepository.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TEMPORARY TABLE #WarehouseReport (OrderId INT, RegionName VARCHAR(255), ProductCategory VARCHAR(255), StockLevel INT, LogisticsEfficiency DECIMAL(10, 2));");

            List<TempItem> tempItems = tempItemRepository.findAll();
            if (tempItems.isEmpty()) {
                throw new RuntimeException("No data found in TempItemRepository");
            }

            String sql = "INSERT INTO #WarehouseReport SELECT o.OrderId, r.RegionName, p.ProductCategory, i.StockLevel, l.LogisticsEfficiency " +
                    "FROM #TempItems AS t " +
                    "JOIN Orders o ON o.OrderId = t.OrderId " +
                    "JOIN Inventory i ON i.OrderId = o.OrderId " +
                    "JOIN Warehouses w ON w.WarehouseId = i.WarehouseId " +
                    "JOIN Products p ON p.ProductId = i.ProductId " +
                    "JOIN Vendors v ON v.VendorId = p.VendorId " +
                    "JOIN Branches b ON b.BranchId = o.BranchId " +
                    "JOIN Regions r ON r.RegionId = b.RegionId " +
                    "JOIN Logistics l ON l.WarehouseId = w.WarehouseId " +
                    "JOIN Employees e ON e.BranchId = b.BranchId " +
                    "JOIN Financials f ON f.BranchId = b.BranchId " +
                    "WHERE (t.OrderId IS NULL OR o.OrderId = t.OrderId) " +
                    "AND (t.RegionName IS NULL OR r.RegionName = t.RegionName) " +
                    "AND (t.ProductCategory IS NULL OR p.ProductCategory = t.ProductCategory) " +
                    "AND (t.StockLevel IS NULL OR i.StockLevel >= t.StockLevel) " +
                    "AND (t.LogisticsEfficiency IS NULL OR l.LogisticsEfficiency >= t.LogisticsEfficiency);";

            statement.execute(sql);
        } catch (SQLException e) {
            // Log error
            throw new RuntimeException("Error generating warehouse report", e);
        }
    }
}