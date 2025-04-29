package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class SalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private AuditDataService auditDataService;

    @Transactional
    public void populateSalesReport() {
        String sql = "CREATE TABLE #SalesReport AS " +
                     "SELECT o.id, o.date, sd.amount, p.name, c.name " +
                     "FROM Order o " +
                     "LEFT JOIN Sales_data sd ON o.id = sd.order_id " +
                     "LEFT JOIN Products p ON sd.product_id = p.id " +
                     "LEFT JOIN Customers c ON o.customer_id = c.id " +
                     "WHERE p.active = true AND sd.valid_discount = true AND o.status = 'completed'";

        try (Connection connection = salesReportRepository.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new CustomException("Error populating sales report", e);
        }
    }

    @Transactional
    public void generateSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            var xmlDocument = builder.parse(xmlData);

            String createTempTableSql = "CREATE TABLE #TempSalesData (id INT, amount DECIMAL(10, 2), product_name VARCHAR(255))";
            try (Connection connection = salesReportRepository.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.execute(createTempTableSql);
            }

            extractDataFromXml(xmlDocument);

            if (isAuditNeeded) {
                Integer defaultManagerId = auditDataService.getDefaultManagerId();
                if (defaultManagerId != null) {
                    auditDataService.insertAuditData(defaultManagerId, orderId);
                }
            }

            insertSalesAndWarehouseReportData(orderId);

        } catch (Exception e) {
            throw new CustomException("Error generating sales report", e);
        }
    }

    private void extractDataFromXml(var xmlDocument) {
        // Implementation for extracting data from xmlDocument and populating temporary tables
    }

    private void insertSalesAndWarehouseReportData(Integer orderId) {
        // Implementation for inserting sales and warehouse report data
    }
}