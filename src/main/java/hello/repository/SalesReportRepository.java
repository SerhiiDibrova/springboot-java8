package hello.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    Logger logger = LoggerFactory.getLogger(SalesReportRepository.class);

    @Transactional
    @Modifying
    @Query(value = "CREATE TEMPORARY TABLE SalesReport AS SELECT * FROM [Order] AS o LEFT JOIN Sales_data AS s ON o.OrderId = s.OrderId", nativeQuery = true)
    void createTemporarySalesReport() throws DataAccessException;

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO SalesReport SELECT * FROM [Order] AS o LEFT JOIN Sales_data AS s ON o.OrderId = s.OrderId", nativeQuery = true)
    void insertIntoSalesReport() throws DataAccessException;

    @Query(value = "SELECT * FROM SalesReport", nativeQuery = true)
    List<SalesReport> findAllSalesReports() throws DataAccessException;

    default void executeSalesReportProcess() {
        try {
            createTemporarySalesReport();
            insertIntoSalesReport();
        } catch (DataAccessException e) {
            logger.error("Error during SalesReport process: {}", e.getMessage());
        }
    }
}