

package hello.service;

import java.util.stream.Stream;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private SalesDataRepository salesDataRepository;

    @Autowired
    private XmlDocumentRepository xmlDocumentRepository;

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private AuditRepository auditRepository;

    public void createSalesReportTable() {
        salesReportRepository.createSalesReportTable();
    }

    public void generateSalesReport() {
        retrieveSalesData();
        applyFiltersAndTransformations();
        generateSalesReport();
    }

    public void getSalesReport(String orderId, String managerId, String xmlData, boolean isAuditNeeded) {
        prepareXmlDocument(xmlData);
        createTemporaryTables();
        insertDataFromXml(xmlData);
        if (isAuditNeeded) {
            performAudit();
        }
        retrieveSalesData();
        retrieveWarehouseReport();
        generateSalesReport();
    }

    private void prepareXmlDocument(String xmlData) {
        xmlDocumentRepository.prepareXmlDocument(xmlData);
    }

    private void createTemporaryTables() {
        tempItemRepository.createTemporaryTables();
    }

    private void insertDataFromXml(String xmlData) {
        tempItemRepository.insertDataFromXml(xmlData);
    }

    private void performAudit() {
        auditRepository.performAudit();
    }

    private void retrieveSalesData() {
        salesDataRepository.retrieveSalesData();
    }

    private void retrieveWarehouseReport() {
        warehouseReportRepository.retrieveWarehouseReport();
    }

    private void generateSalesReport() {
        salesReportRepository.generateSalesReport();
    }

    private void applyFiltersAndTransformations() {
        Predicate<SalesData> filterByOrderId = salesData -> salesData.getOrderId().equals("orderId");
        Predicate<SalesData> filterByManagerId = salesData -> salesData.getManagerId().equals("managerId");
        salesDataRepository.getSalesData().stream()
                .filter(filterByOrderId.and(filterByManagerId))
                .map(salesData -> {
                    salesData.setQuantity(salesData.getQuantity() * 2);
                    return salesData;
                })
                .forEach(salesData -> salesDataRepository.updateSalesData(salesData));
    }
}