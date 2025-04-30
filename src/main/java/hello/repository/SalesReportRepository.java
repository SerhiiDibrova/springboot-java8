package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    SalesReport findByOrderId(Integer orderId);

    @Query("SELECT sr FROM SalesReport sr WHERE sr.someField = ?1")
    List<SalesReport> findBySomeField(String someField);
}