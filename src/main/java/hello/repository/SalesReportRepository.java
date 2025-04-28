package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import java.util.List;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByOrderId(Integer orderId) throws DataAccessException;
    List<SalesReport> findByManagerId(Integer managerId) throws DataAccessException;
    List<SalesReport> findByOrderIdAndManagerId(Integer orderId, Integer managerId) throws DataAccessException;
}