package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.service.InsertSalesReportService;
import hello.model.SalesReportModel;
import hello.repository.SalesReportRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

@Service
public class SalesReportService {

    @Autowired
    private InsertSalesReportService insertSalesReportService;

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Transactional
    public void generateSalesReport(String orderId, String managerId, String xmlData, boolean isAuditNeeded) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document;

        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(xmlData);

            connection = salesReportRepository.getConnection();
            preparedStatement = connection.prepareStatement("CREATE TEMPORARY TABLE temp_sales_report (column1 TYPE, column2 TYPE, ...)");
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("INSERT INTO temp_sales_report (column1, column2, ...) VALUES (?, ?, ...)");
            // Set parameters for preparedStatement here
            preparedStatement.executeUpdate();

            if (isAuditNeeded) {
                // Implement auditing logic here
            }

            insertSalesReportService.insertSalesReport(orderId, managerId, document);

            preparedStatement = connection.prepareStatement("SELECT ... FROM temp_sales_report ...");
            preparedStatement.executeQuery();

        } catch (Exception e) {
            throw new RuntimeException("Error generating sales report", e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) {
                    connection.prepareStatement("DROP TABLE IF EXISTS temp_sales_report").executeUpdate();
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error closing resources", e);
            }
        }
    }
}