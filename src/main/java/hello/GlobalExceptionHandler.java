package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesReportService {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public String populateSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            var document = builder.parse(new ByteArrayInputStream(xmlData.getBytes()));

            List<TempItem> tempItems = new ArrayList<>();
            var nodeList = document.getElementsByTagName("Item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                var node = nodeList.item(i);
                var tempItem = new TempItem();
                tempItem.setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue()));
                tempItem.setName(node.getAttributes().getNamedItem("name").getNodeValue());
                tempItem.setQuantity(Integer.parseInt(node.getAttributes().getNamedItem("quantity").getNodeValue()));
                tempItems.add(tempItem);
            }

            tempItemRepository.saveAll(tempItems);

            if (isAuditNeeded != null && isAuditNeeded) {
                Integer defaultManagerId = getDefaultManagerId(managerId);
                if (defaultManagerId != null) {
                    insertAuditData(defaultManagerId);
                }
            }

            SalesReport salesReport = new SalesReport();
            salesReport.setOrderId(orderId);
            salesReport.setTotalItems(tempItems.size());
            salesReportRepository.save(salesReport);

            WarehouseReport warehouseReport = new WarehouseReport();
            warehouseReport.setOrderId(orderId);
            warehouseReport.setTotalItems(tempItems.size());
            warehouseReportRepository.save(warehouseReport);

            return "Sales report populated successfully.";
        } catch (ParserConfigurationException | IOException | TransformerException e) {
            logger.error("Error populating sales report", e);
            throw new RuntimeException("Failed to populate sales report.");
        }
    }

    private Integer getDefaultManagerId(Integer managerId) {
        return managerId != null ? managerId : 1; // Placeholder for default manager ID logic
    }

    private void insertAuditData(Integer managerId) {
        // Logic to insert audit data
    }
}