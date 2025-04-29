package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.repository.WarehouseReportRepository;
import hello.service.TempItemService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class WarehouseReportService {

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private TempItemService tempItemService;

    @Transactional
    public void insertWarehouseReport() {
        String sql = "CREATE TABLE #WarehouseReport AS " +
                     "SELECT o.order_id, i.item_id, w.warehouse_id " +
                     "FROM Orders o " +
                     "JOIN Inventory i ON o.item_id = i.item_id " +
                     "JOIN Warehouses w ON i.warehouse_id = w.warehouse_id " +
                     "WHERE i.item_id IN (SELECT item_id FROM #TempItems)";

        try (Connection connection = warehouseReportRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            checkUserPermissions();
            preparedStatement.execute();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void checkUserPermissions() {
        // Implement permission check logic here
    }

    private void handleSQLException(SQLException e) {
        // Implement specific error handling for different SQL exceptions
        throw new RuntimeException("Error inserting warehouse report: " + e.getMessage(), e);
    }
}