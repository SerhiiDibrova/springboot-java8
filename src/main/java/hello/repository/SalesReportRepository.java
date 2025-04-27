package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.SalesReport;

public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    // Custom method for executing SQL insertion logic can be defined here if needed
}