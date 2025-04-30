package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseReportService {

    private final WarehouseReportRepository warehouseReportRepository;
    private final ErrorHandlingService errorHandlingService;

    @Autowired
    public WarehouseReportService(WarehouseReportRepository warehouseReportRepository, ErrorHandlingService errorHandlingService) {
        this.warehouseReportRepository = warehouseReportRepository;
        this.errorHandlingService = errorHandlingService;
    }

    @Transactional
    public void populateWarehouseReport() {
        try {
            if (warehouseReportRepository.isTempItemsDataAvailable()) {
                warehouseReportRepository.populateWarehouseReport();
            } else {
                throw new RuntimeException("No data available in TempItems table.");
            }
        } catch (Exception e) {
            errorHandlingService.logError(e);
            throw e;
        }
    }
}