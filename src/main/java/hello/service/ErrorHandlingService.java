package hello.service;

import hello.repository.ErrorLogRepository;
import hello.model.ErrorLog;
import hello.repository.SalesReportRepository;
import hello.repository.WarehouseReportRepository;
import hello.repository.TempItemsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ErrorHandlingService {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingService.class);
    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorHandlingService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void handleDatabaseOperation(Runnable operation) {
        String errorMessage;
        try {
            operation.run();
        } catch (Exception e) {
            errorMessage = e.getMessage();
            ErrorLog errorLog = new ErrorLog(errorMessage, 0, 0, LocalDateTime.now());
            errorLogRepository.save(errorLog);
            logger.error(errorMessage);
        }
    }
}

@Service
public class SalesReportService {

    private final SalesReportRepository salesReportRepository;
    private final WarehouseReportRepository warehouseReportRepository;
    private final TempItemsRepository tempItemsRepository;
    private final ErrorHandlingService errorHandlingService;

    @Autowired
    public SalesReportService(SalesReportRepository salesReportRepository,
                              WarehouseReportRepository warehouseReportRepository,
                              TempItemsRepository tempItemsRepository,
                              ErrorHandlingService errorHandlingService) {
        this.salesReportRepository = salesReportRepository;
        this.warehouseReportRepository = warehouseReportRepository;
        this.tempItemsRepository = tempItemsRepository;
        this.errorHandlingService = errorHandlingService;
    }

    @Transactional
    public void generateSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null || xmlData.isEmpty()) {
            throw new IllegalArgumentException("orderId and xmlData must not be null or empty");
        }

        errorHandlingService.handleDatabaseOperation(() -> {
            int hDoc;
            // Assume sp_xml_preparedocument is called here

            // Create temporary tables
            // Assume temporary tables are created here

            // Insert data from XML
            // Assume data is inserted from XML here

            if (isAuditNeeded) {
                Integer defaultManagerId = getDefaultManagerId(managerId);
                if (defaultManagerId != null) {
                    insertAuditData(defaultManagerId);
                }
            }
            insertSalesReportData();
            insertWarehouseReportData();
        });
    }

    private Integer getDefaultManagerId(Integer managerId) {
        // Implementation to get default manager ID
        return managerId; // Placeholder
    }

    private void insertAuditData(Integer managerId) {
        // Implementation to insert audit data
    }

    private void insertSalesReportData() {
        // Implementation to insert sales report data
    }

    private void insertWarehouseReportData() {
        // Implementation to insert warehouse report data
    }
}