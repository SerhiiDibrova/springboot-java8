package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.WarehouseReportRepository;

@Service
public class WarehouseReportService {

    private final WarehouseReportRepository warehouseReportRepository;

    @Autowired
    public WarehouseReportService(WarehouseReportRepository warehouseReportRepository) {
        this.warehouseReportRepository = warehouseReportRepository;
    }

    public void insertWarehouseReport(String xmlData) {
        warehouseReportRepository.createTempWarehouseReportTable();
        warehouseReportRepository.insertWarehouseReportData(xmlData);
    }
}