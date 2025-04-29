package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.SalesReport;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
}