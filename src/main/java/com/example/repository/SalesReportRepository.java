package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SalesReportRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTempItemsTable() {
        jdbcTemplate.execute("CREATE TABLE TempItems (id INT PRIMARY KEY, itemName VARCHAR(255), quantity INT);");
    }

    public void createWarehouseReportTable() {
        jdbcTemplate.execute("CREATE TABLE WarehouseReport (warehouseId INT PRIMARY KEY, warehouseName VARCHAR(255), totalItems INT);");
    }

    public void createSalesReportTable() {
        jdbcTemplate.execute("CREATE TABLE SalesReport (reportId INT PRIMARY KEY, reportDate DATE, totalSales DECIMAL(10, 2));");
    }

    public void executeInsert(String sql) {
        jdbcTemplate.execute(sql);
    }
}