package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import org.w3c.dom.Document;

@Service
public class SalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private InsertSalesReportService insertSalesReportService;

    @Autowired
    private AuditService auditService;

    @Autowired
    private TempItemsService tempItemsService;

    @Transactional
    public SalesReportDTO getSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null) {
            throw new CustomException("Order ID and XML data are mandatory.");
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new ByteArrayInputStream(xmlData.getBytes()));
            salesReportRepository.createTempTable(orderId);
            tempItemsService.insertDataFromXml(xmlDocument);
            if (isAuditNeeded != null && isAuditNeeded) {
                Integer defaultManagerId = auditService.getDefaultManagerId(managerId);
                if (managerId != null) {
                    auditService.insertAuditData(managerId);
                }
            }
            insertSalesReportService.insertSalesReport();
            warehouseReportRepository.insertWarehouseReport();
            return new SalesReportDTO(orderId, managerId);
        } catch (Exception e) {
            throw new CustomException("Error generating sales report: " + e.getMessage(), e);
        }
    }
}