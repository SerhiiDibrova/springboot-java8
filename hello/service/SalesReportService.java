package hello.service;

import hello.dto.SalesReportRequest;
import hello.repository.SalesReportRepository;
import hello.repository.TempItemsRepository;
import hello.repository.WarehouseDataRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class SalesReportService {

    private final SalesReportRepository salesReportRepository;
    private final TempItemsRepository tempItemsRepository;
    private final WarehouseDataRepository warehouseDataRepository;
    private final JdbcTemplate jdbcTemplate;

    public SalesReportService(SalesReportRepository salesReportRepository,
                              TempItemsRepository tempItemsRepository,
                              WarehouseDataRepository warehouseDataRepository,
                              JdbcTemplate jdbcTemplate) {
        this.salesReportRepository = salesReportRepository;
        this.tempItemsRepository = tempItemsRepository;
        this.warehouseDataRepository = warehouseDataRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void generateSalesReport(SalesReportRequest request) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            var document = documentBuilder.newDocument();
            var root = document.createElement("SalesReport");
            document.appendChild(root);

            createTemporaryTables();
            insertDataFromXML(request);
            handleAuditData(request);
            cleanupResources();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(System.out);
            transformer.transform(domSource, streamResult);
        } catch (Exception e) {
            throw new RuntimeException("Error generating sales report", e);
        }
    }

    private void createTemporaryTables() {
        try (Connection connection = jdbcTemplate.getDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TEMPORARY TABLE temp_items (id INT, name VARCHAR(255))");
        } catch (SQLException e) {
            throw new RuntimeException("Error creating temporary tables", e);
        }
    }

    private void insertDataFromXML(SalesReportRequest request) {
        // Implementation for inserting data from XML
    }

    private void handleAuditData(SalesReportRequest request) {
        // Implementation for handling audit data
    }

    private void cleanupResources() {
        // Implementation for cleaning up resources
    }
}