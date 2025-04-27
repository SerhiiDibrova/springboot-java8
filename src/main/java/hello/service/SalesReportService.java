package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import hello.repository.SalesReportRepository;
import hello.repository.SalesDataRepository;
import org.springframework.dao.DataAccessException;

@Service
public class SalesReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private SalesDataRepository salesDataRepository;

    public void populateSalesReport() {
        String sql = "CREATE TABLE #SalesReport AS " +
                     "SELECT CASE WHEN column1 IS NULL THEN 'Default' ELSE column1 END AS column1, " +
                     "       CASE WHEN column2 IS NULL THEN 0 ELSE column2 END AS column2 " +
                     "FROM SalesData " +
                     "WHERE some_condition; " +
                     "INSERT INTO SalesReport (column1, column2) " +
                     "SELECT column1, column2 FROM #SalesReport; " +
                     "DROP TABLE #SalesReport;";

        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error populating sales report", e);
        }
    }
}