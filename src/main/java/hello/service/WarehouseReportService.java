package hello.service;

import hello.repository.WarehouseReportRepository;
import hello.repository.TempItemRepository;
import hello.repository.OrdersRepository;
import hello.repository.InventoryRepository;
import hello.repository.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private WarehousesRepository warehousesRepository;

    @Transactional
    public void insertWarehouseReport(String filterParam1, String filterParam2) {
        String createTableSql = "CREATE TABLE #WarehouseReport (id INT PRIMARY KEY, item_name VARCHAR(255), quantity INT, warehouse_name VARCHAR(255), vendor_name VARCHAR(255))";
        jdbcTemplate.execute(createTableSql);

        String insertDataSql = "INSERT INTO #WarehouseReport (id, item_name, quantity, warehouse_name, vendor_name) " +
                "SELECT ti.id, ti.item_name, SUM(i.quantity), w.name, v.name " +
                "FROM #TempItems ti " +
                "JOIN Orders o ON ti.order_id = o.id " +
                "JOIN Inventory i ON ti.item_id = i.id " +
                "JOIN Warehouses w ON i.warehouse_id = w.id " +
                "JOIN Products p ON i.product_id = p.id " +
                "JOIN Vendors v ON p.vendor_id = v.id " +
                "JOIN Branches b ON w.branch_id = b.id " +
                "JOIN Regions r ON b.region_id = r.id " +
                "JOIN Legacy_Logistics ll ON o.logistics_id = ll.id " +
                "JOIN Employees e ON o.employee_id = e.id " +
                "JOIN Legacy_Financials lf ON o.financial_id = lf.id " +
                "WHERE (ti.filter_column1 = ? OR ? IS NULL) " +
                "AND (ti.filter_column2 = ? OR ? IS NULL) " +
                "GROUP BY ti.id, ti.item_name, w.name, v.name";

        try {
            jdbcTemplate.update(insertDataSql, filterParam1, filterParam1, filterParam2, filterParam2);
        } catch (DataAccessException e) {
            throw new CustomDatabaseException("Error inserting data into #WarehouseReport", e);
        }
    }
}