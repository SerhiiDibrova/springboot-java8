

package hello.service;

import hello.dto.WarehouseReportDTO;
import hello.repository.WarehouseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WarehouseReportService {

    private final WarehouseReportRepository warehouseReportRepository;

    @Autowired
    public WarehouseReportService(WarehouseReportRepository warehouseReportRepository) {
        this.warehouseReportRepository = warehouseReportRepository;
    }

    @Transactional
    public List<WarehouseReportDTO> generateWarehouseReport() {
        try {
            warehouseReportRepository.createWarehouseReportTable();
            List<WarehouseReportDTO> warehouseReportDTOs = warehouseReportRepository.joinTablesAndSelectColumns();
            warehouseReportRepository.insertIntoWarehouseReportTable(warehouseReportDTOs);
            return warehouseReportDTOs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void createWarehouseReportTable() {
        warehouseReportRepository.createWarehouseReportTable();
    }
}