package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class SalesReportService {

    private final SalesReportRepository salesReportRepository;
    private final TempItemRepository tempItemRepository;
    private final EntityManager entityManager;

    @Autowired
    public SalesReportService(SalesReportRepository salesReportRepository, TempItemRepository tempItemRepository, EntityManager entityManager) {
        this.salesReportRepository = salesReportRepository;
        this.tempItemRepository = tempItemRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public void generateSalesReport() {
        try {
            createTemporarySalesReportTable();
            List<Object[]> results = fetchSalesData();
            for (Object[] result : results) {
                SalesReport salesReport = createSalesReport(result);
                validateSalesReport(salesReport);
                salesReportRepository.save(salesReport);
            }
        } catch (PersistenceException e) {
            // Handle exception (e.g., log the error)
        }
    }

    private void createTemporarySalesReportTable() {
        String createTableQuery = "CREATE TEMPORARY TABLE TempSalesReport AS SELECT * FROM SalesReport WHERE 1=0";
        entityManager.createNativeQuery(createTableQuery).executeUpdate();
    }

    private List<Object[]> fetchSalesData() {
        String query = "SELECT o.id, o.date, p.name, SUM(s.amount), " +
                       "CASE WHEN i.stock_level > 0 THEN 'In Stock' ELSE 'Out of Stock' END AS stock_status " +
                       "FROM Orders o " +
                       "LEFT JOIN Sales s ON o.id = s.order_id " +
                       "LEFT JOIN Products p ON s.product_id = p.id " +
                       "LEFT JOIN Inventory i ON p.id = i.product_id " +
                       "WHERE i.stock_level <= 0 " +
                       "GROUP BY o.id, o.date, p.name";
        return entityManager.createQuery(query).getResultList();
    }

    private SalesReport createSalesReport(Object[] result) {
        SalesReport salesReport = new SalesReport();
        salesReport.setOrderId((Long) result[0]);
        salesReport.setDate((Date) result[1]);
        salesReport.setProductName((String) result[2]);
        salesReport.setTotalAmount((BigDecimal) result[3]);
        salesReport.setStockStatus((String) result[4]);
        return salesReport;
    }

    private void validateSalesReport(SalesReport salesReport) {
        if (salesReport.getTotalAmount() == null || salesReport.getTotalAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid sales report data");
        }
    }
}