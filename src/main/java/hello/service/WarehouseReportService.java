package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.dto.WarehouseReportDTO;
import hello.repository.WarehouseReportRepository;

import java.util.List;

@Service
public class WarehouseReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Transactional
    public void insertWarehouseReportData(List<WarehouseReportDTO> reportData) {
        try {
            jdbcTemplate.execute("CREATE TABLE #WarehouseReport (Column1 INT, Column2 VARCHAR(255), Column3 DATE);");
            for (WarehouseReportDTO data : reportData) {
                jdbcTemplate.update("INSERT INTO #WarehouseReport (Column1, Column2, Column3) VALUES (?, ?, ?)",
                    data.getColumn1(), data.getColumn2(), data.getColumn3());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while inserting warehouse report data: " + e.getMessage(), e);
        } finally {
            jdbcTemplate.execute("DROP TABLE #WarehouseReport;");
        }
    }
}