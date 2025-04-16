

package hello.service;

import hello.entity.WarehouseReportEntity;
import hello.repository.WarehouseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class WarehouseReportService {

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<WarehouseReportEntity> getWarehouseReport() {
        createTemporaryTable();
        joinTables();
        selectAndInsertData();
        return warehouseReportRepository.getWarehouseReport();
    }

    private void createTemporaryTable() {
        Query query = entityManager.createNativeQuery("CREATE TABLE #WarehouseReport (id INT, name VARCHAR(255), quantity INT, product_id INT, product_name VARCHAR(255))");
        query.executeUpdate();
    }

    private void joinTables() {
        Query query = entityManager.createNativeQuery("INSERT INTO #WarehouseReport (id, name, quantity, product_id, product_name) SELECT w.id, w.name, SUM(i.quantity), p.id, p.name FROM Warehouse w INNER JOIN Inventory i ON w.id = i.warehouse_id INNER JOIN Product p ON i.product_id = p.id GROUP BY w.id, w.name, p.id, p.name");
        query.executeUpdate();
    }

    private void selectAndInsertData() {
        Query query = entityManager.createNativeQuery("INSERT INTO #WarehouseReport (id, name, quantity, product_id, product_name) SELECT w.id, w.name, SUM(i.quantity), p.id, p.name FROM Warehouse w INNER JOIN Inventory i ON w.id = i.warehouse_id INNER JOIN Product p ON i.product_id = p.id GROUP BY w.id, w.name, p.id, p.name");
        query.executeUpdate();
    }
}