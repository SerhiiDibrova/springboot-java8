package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesReportService {

    private final SalesReportRepository salesReportRepository;
    private final WarehouseReportService warehouseReportService;
    private final AuditService auditService;
    private final GetDefaultManagerIdService getDefaultManagerIdService;
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    public SalesReportService(SalesReportRepository salesReportRepository,
                              WarehouseReportService warehouseReportService,
                              AuditService auditService,
                              GetDefaultManagerIdService getDefaultManagerIdService,
                              JdbcTemplate jdbcTemplate) {
        this.salesReportRepository = salesReportRepository;
        this.warehouseReportService = warehouseReportService;
        this.auditService = auditService;
        this.getDefaultManagerIdService = getDefaultManagerIdService;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertSalesReport() {
        try {
            jdbcTemplate.execute("CREATE TABLE #SalesReport (OrderId INT, ManagerId INT, ...)");
            String sql = "INSERT INTO #SalesReport SELECT o.OrderId, o.ManagerId, ... FROM [Order] o LEFT JOIN Sales_data s ON o.OrderId = s.OrderId ... WHERE ...";
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            logger.error("Error inserting sales report data: ", e);
            throw new CustomDatabaseException("Failed to insert sales report data", e);
        }
    }

    @Transactional
    public SalesReportDTO getSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null) {
            throw new CustomException("Order ID and XML data are mandatory.");
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new ByteArrayInputStream(xmlData.getBytes()));
            if (managerId == null) {
                managerId = getDefaultManagerIdService.getDefaultManagerId(managerId);
            }
            List<Item> tempItems = new ArrayList<>();
            NodeList filters = xmlDocument.getElementsByTagName("Filter");
            for (int i = 0; i < filters.getLength(); i++) {
                // Extract data and populate tempItems
            }
            if (isAuditNeeded != null && isAuditNeeded) {
                auditService.insertAuditData(managerId);
            }
            insertSalesReport();
            warehouseReportService.insertWarehouseReport();
            return new SalesReportDTO(orderId, managerId);
        } catch (Exception e) {
            logger.error("Error generating sales report: ", e);
            throw new CustomException("Error generating sales report: " + e.getMessage(), e);
        }
    }
}