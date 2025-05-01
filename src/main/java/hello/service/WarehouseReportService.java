package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Service
public class WarehouseReportService {

    private final WarehouseReportRepository warehouseReportRepository;
    private final TempItemRepository tempItemRepository;
    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;
    private final WarehouseRepository warehouseRepository;
    private final SalesReportRepository salesReportRepository;

    @Autowired
    public WarehouseReportService(WarehouseReportRepository warehouseReportRepository,
                                   TempItemRepository tempItemRepository,
                                   OrderRepository orderRepository,
                                   InventoryRepository inventoryRepository,
                                   WarehouseRepository warehouseRepository,
                                   SalesReportRepository salesReportRepository) {
        this.warehouseReportRepository = warehouseReportRepository;
        this.tempItemRepository = tempItemRepository;
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
        this.warehouseRepository = warehouseRepository;
        this.salesReportRepository = salesReportRepository;
    }

    public void populateWarehouseReport() {
        try {
            warehouseReportRepository.createTemporaryTable();
            List<TempItem> tempItems = tempItemRepository.findAll();
            warehouseReportRepository.populateWarehouseReport(tempItems);
        } catch (Exception e) {
            throw new RuntimeException("Error populating warehouse report", e);
        }
    }

    @Transactional
    public String populateSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null) {
            throw new IllegalArgumentException("Order ID and XML data are required.");
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new InputSource(new StringReader(xmlData)));
            List<TempItem> tempItems = new ArrayList<>();
            NodeList itemNodes = xmlDocument.getElementsByTagName("Item");
            for (int i = 0; i < itemNodes.getLength(); i++) {
                TempItem tempItem = new TempItem();
                // Set fields from XML
                tempItem.setOrderId(Integer.parseInt(itemNodes.item(i).getAttributes().getNamedItem("OrderId").getNodeValue()));
                tempItem.setRegionName(itemNodes.item(i).getAttributes().getNamedItem("RegionName").getNodeValue());
                tempItem.setProductCategory(itemNodes.item(i).getAttributes().getNamedItem("ProductCategory").getNodeValue());
                tempItem.setStockLevel(Integer.parseInt(itemNodes.item(i).getAttributes().getNamedItem("StockLevel").getNodeValue()));
                tempItem.setLogisticsEfficiency(Integer.parseInt(itemNodes.item(i).getAttributes().getNamedItem("LogisticsEfficiency").getNodeValue()));
                tempItems.add(tempItem);
            }
            tempItemRepository.saveAll(tempItems);
            if (isAuditNeeded) {
                Integer defaultManagerId = getDefaultManagerId(managerId);
                if (defaultManagerId != null) {
                    insertAuditData(defaultManagerId);
                }
            }
            insertSalesReport();
            insertWarehouseReport();
            return "Sales report populated successfully.";
        } catch (Exception e) {
            throw new RuntimeException("Error populating sales report", e);
        }
    }

    private Integer getDefaultManagerId(Integer managerId) {
        // Implementation to retrieve default manager ID
        return null;
    }

    private void insertAuditData(Integer managerId) {
        // Implementation to insert audit data
    }

    private void insertSalesReport() {
        // Implementation to insert sales report
    }

    private void insertWarehouseReport() {
        // Implementation to insert warehouse report
    }
}