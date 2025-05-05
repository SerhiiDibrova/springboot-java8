package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesReportService {

    private final SalesReportRepository salesReportRepository;
    private final WarehouseReportService warehouseReportService;
    private final AuditService auditService;
    private final GetDefaultManagerIdService getDefaultManagerIdService;

    @Autowired
    public SalesReportService(SalesReportRepository salesReportRepository,
                              WarehouseReportService warehouseReportService,
                              AuditService auditService,
                              GetDefaultManagerIdService getDefaultManagerIdService) {
        this.salesReportRepository = salesReportRepository;
        this.warehouseReportService = warehouseReportService;
        this.auditService = auditService;
        this.getDefaultManagerIdService = getDefaultManagerIdService;
    }

    public void insertSalesReport() {
        try {
            salesReportRepository.executeInsertSalesReport();
        } catch (Exception e) {
            // Log error
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
            // Log error
            throw new CustomException("Error generating sales report: " + e.getMessage(), e);
        }
    }
}