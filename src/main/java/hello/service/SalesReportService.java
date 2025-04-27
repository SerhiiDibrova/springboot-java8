package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import hello.service.GetSalesDataService;
import hello.repository.SalesReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class SalesReportService {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GetSalesDataService getSalesDataService;

    @Autowired
    private SalesReportRepository salesReportRepository;

    public void insertSalesReportData(String parameter1, String parameter2) {
        if (parameter1 == null || parameter2 == null) {
            logger.error("Invalid parameters: parameter1 or parameter2 is null");
            return;
        }

        String createTableSQL = "IF OBJECT_ID('tempdb..#SalesReport') IS NULL " +
                                 "CREATE TABLE #SalesReport (Column1 INT, Column2 VARCHAR(255))";
        jdbcTemplate.execute(createTableSQL);

        List<SalesData> salesData;
        try {
            salesData = getSalesDataService.getSalesData(parameter1, parameter2);
        } catch (Exception e) {
            logger.error("Error retrieving sales data", e);
            return;
        }

        String insertSQL = "INSERT INTO #SalesReport (Column1, Column2) VALUES (?, ?)";
        for (SalesData data : salesData) {
            try {
                jdbcTemplate.update(insertSQL, data.getColumn1() != null ? data.getColumn1() : 0, 
                                    data.getColumn2() != null ? data.getColumn2() : "");
            } catch (Exception e) {
                logger.error("Error inserting data into #SalesReport", e);
            }
        }
    }
}