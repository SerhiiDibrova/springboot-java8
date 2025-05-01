package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Service
public class SalesReportService {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public String populateSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new InputSource(new StringReader(xmlData)));

            List<TempItem> tempItems = new ArrayList<>();
            NodeList itemNodes = xmlDocument.getElementsByTagName("Item");
            for (int i = 0; i < itemNodes.getLength(); i++) {
                TempItem tempItem = new TempItem();
                tempItem.setField1(itemNodes.item(i).getAttributes().getNamedItem("Field1").getNodeValue());
                tempItem.setField2(itemNodes.item(i).getAttributes().getNamedItem("Field2").getNodeValue());
                tempItems.add(tempItem);
            }
            tempItemRepository.saveAll(tempItems);

            if (isAuditNeeded) {
                Integer defaultManagerId = GetDefaultManagerId(managerId);
                if (defaultManagerId != null) {
                    InsertAuditData(defaultManagerId);
                }
            }

            String sql = "INSERT INTO #SalesReport (Column1, Column2) SELECT Field1, Field2 FROM #TempItems";
            entityManager.createNativeQuery(sql).executeUpdate();
            InsertSalesReport();
            InsertWarehouseReport();

            return "Sales report populated successfully.";
        } catch (Exception e) {
            logger.error("Error populating SalesReport: " + e.getMessage());
            throw new RuntimeException("Failed to populate SalesReport");
        }
    }

    private Integer GetDefaultManagerId(Integer managerId) {
        // Implementation to get default manager ID
        return managerId != null ? managerId : 1; // Example implementation
    }

    private void InsertAuditData(Integer managerId) {
        // Implementation to insert audit data
    }

    private void InsertSalesReport() {
        // Implementation to insert sales report
    }

    private void InsertWarehouseReport() {
        // Implementation to insert warehouse report
    }
}