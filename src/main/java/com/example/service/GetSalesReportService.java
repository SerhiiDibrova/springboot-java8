package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.SalesReportRepository;
import com.example.service.GetDefaultManagerIdService;
import com.example.service.AuditDataService;
import com.example.service.ErrorHandlingService;

@Service
public class GetSalesReportService {
    @Autowired
    private SalesReportRepository salesReportRepository;
    @Autowired
    private GetDefaultManagerIdService defaultManagerIdService;
    @Autowired
    private AuditDataService auditDataService;

    public void generateSalesReport(int orderId, Integer managerId, String xmlData, boolean isAuditNeeded) {
        int hDoc = prepareXmlDocument(xmlData);

        try {
            salesReportRepository.createTempItemsTable();
            salesReportRepository.createWarehouseReportTable();
            salesReportRepository.createSalesReportTable();

            insertTempItems(hDoc);

            if (isAuditNeeded) {
                managerId = defaultManagerIdService.getDefaultManagerId(managerId);
                if (managerId != null) {
                    auditDataService.insertAuditData(managerId);
                }
            }

            salesReportRepository.executeInsert("INSERT INTO #SalesReport SELECT * FROM GetSalesData(" + orderId + ", #TempItems)");
            salesReportRepository.executeInsert("INSERT INTO #WarehouseReport SELECT * FROM GetWarehouseData(#TempItems)");

        } catch (Exception e) {
            ErrorHandlingService.handleError(e);
        } finally {
            cleanupXmlDocument(hDoc);
        }
    }

    private int prepareXmlDocument(String xmlData) {
        // Logic to prepare XML document and return handle
        return 1; // Implement actual logic
    }

    private void insertTempItems(int hDoc) {
        // Logic to insert data into #TempItems using OPENXML
    }

    private void cleanupXmlDocument(int hDoc) {
        // Logic to clean up XML document
    }
}