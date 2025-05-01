package hello.service;

import hello.repository.WarehouseReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarehouseReportService {
    private final WarehouseReportRepository warehouseReportRepository;
    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportService.class);

    public WarehouseReportService(WarehouseReportRepository warehouseReportRepository) {
        this.warehouseReportRepository = warehouseReportRepository;
    }

    public void generateWarehouseReport() {
        try {
            warehouseReportRepository.insertWarehouseReportData();
            logger.info("Warehouse report generated successfully.");
        } catch (Exception e) {
            logger.error("Error generating warehouse report: " + e.getMessage(), e);
            throw new RuntimeException("Failed to generate warehouse report", e);
        }
    }
}