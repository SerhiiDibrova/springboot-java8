package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {

    @Modifying
    @Transactional
    void insertSalesData(List<SalesDataDTO> salesData);

    @Modifying
    @Transactional
    void insertWarehouseData(List<WarehouseDataDTO> warehouseData);

    @Modifying
    @Transactional
    void insertSalesData();
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SalesReportRepositoryImpl implements SalesReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertSalesData(List<SalesDataDTO> salesData) {
        String sql = "INSERT INTO #SalesReport (columns) VALUES (?, ?, ...)"; // Define columns and placeholders
        jdbcTemplate.batchUpdate(sql, salesData, salesData.size(), (ps, salesDataDTO) -> {
            ps.setObject(1, salesDataDTO.getField1());
            ps.setObject(2, salesDataDTO.getField2());
            // Set other fields
        });
    }

    @Override
    public void insertWarehouseData(List<WarehouseDataDTO> warehouseData) {
        String sql = "INSERT INTO #WarehouseReport (columns) VALUES (?, ?, ...)"; // Define columns and placeholders
        jdbcTemplate.batchUpdate(sql, warehouseData, warehouseData.size(), (ps, warehouseDataDTO) -> {
            ps.setObject(1, warehouseDataDTO.getField1());
            ps.setObject(2, warehouseDataDTO.getField2());
            // Set other fields
        });
    }

    @Override
    public void insertSalesData() {
        String sql = "INSERT INTO #SalesReport " +
                     "SELECT columns FROM [Order] o " +
                     "LEFT JOIN Sales_data s ON o.OrderId = s.OrderId " +
                     "LEFT JOIN TempItems t ON s.ItemId = t.ItemId " +
                     "... WHERE filtering conditions"; // Define filtering conditions
        jdbcTemplate.update(sql);
    }
}