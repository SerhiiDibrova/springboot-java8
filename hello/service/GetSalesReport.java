

package hello.service;

import hello.exceptions.InvalidInputException;
import hello.exceptions.ReportGenerationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSalesReport {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetSalesReport.class);

    private final PrepareXmlDocument prepareXmlDocument;
    private final CreateTemporaryTables createTemporaryTables;
    private final InsertDataFromXml insertDataFromXml;
    private final PerformAudit performAudit;
    private final GetSalesData getSalesData;
    private final GetWarehouseReport getWarehouseReport;

    @Autowired
    public GetSalesReport(PrepareXmlDocument prepareXmlDocument, CreateTemporaryTables createTemporaryTables, InsertDataFromXml insertDataFromXml, PerformAudit performAudit, GetSalesData getSalesData, GetWarehouseReport getWarehouseReport) {
        this.prepareXmlDocument = prepareXmlDocument;
        this.createTemporaryTables = createTemporaryTables;
        this.insertDataFromXml = insertDataFromXml;
        this.performAudit = performAudit;
        this.getSalesData = getSalesData;
        this.getWarehouseReport = getWarehouseReport;
    }

    public String generateSalesReport(String orderId, String managerId, String xmlData, boolean isAuditNeeded) {
        if (orderId == null || orderId.isEmpty() || managerId == null || managerId.isEmpty() || xmlData == null || xmlData.isEmpty()) {
            LOGGER.error("Invalid input parameters");
            throw new InvalidInputException("Invalid input parameters");
        }

        try {
            String preparedXml = prepareXmlDocument.prepareXml(xmlData);
            createTemporaryTables.createTables();
            insertDataFromXml.insertData(preparedXml);
            if (isAuditNeeded) {
                performAudit.performAudit(orderId, managerId);
            }
            String salesData = getSalesData.getSalesData(orderId);
            return getWarehouseReport.generateReport(salesData);
        } catch (Exception e) {
            LOGGER.error("Error generating sales report", e);
            throw new ReportGenerationException("Error generating sales report", e);
        }
    }
}