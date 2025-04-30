package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void generateSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null || xmlData.isEmpty()) {
            throw new IllegalArgumentException("Order ID and XML data are mandatory.");
        }

        List<TempItem> tempItems = new ArrayList<>();
        List<WarehouseReport> warehouseReports = new ArrayList<>();
        List<SalesReport> salesReports = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlData);
            NodeList itemNodes = document.getElementsByTagName("TempItem");

            for (int i = 0; i < itemNodes.getLength(); i++) {
                // Populate tempItems from XML
                TempItem tempItem = new TempItem();
                // Set properties of tempItem based on XML data
                tempItems.add(tempItem);
            }

            if (isAuditNeeded) {
                managerId = getDefaultManagerId(managerId);
                if (managerId != null) {
                    logAuditData(managerId);
                }
            }

            warehouseReports = warehouseReportRepository.findAll();
            for (WarehouseReport wr : warehouseReports) {
                if (wr.getStockLevel() == 0) {
                    SalesReport salesReport = new SalesReport();
                    salesReport.setSalesStatus(wr.getSalesAmount() > 0 ? "Enabled" : "Disabled");
                    salesReports.add(salesReport);
                }
            }

            salesReportRepository.saveAll(salesReports);
            warehouseReportRepository.saveAll(warehouseReports);
            tempItemRepository.saveAll(tempItems);
        } catch (Exception e) {
            // Log error
            throw new RuntimeException("Error generating sales report", e);
        }
    }

    private Integer getDefaultManagerId(Integer managerId) {
        // Logic to retrieve default manager ID
        return managerId;
    }

    private void logAuditData(Integer managerId) {
        // Logic to log audit data
    }
}