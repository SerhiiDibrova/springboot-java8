package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findAll();

    Page<SalesReport> findAll(Pageable pageable);

    @Query("SELECT s FROM SalesReport s WHERE s.status = :status")
    List<SalesReport> findByStatus(@Param("status") String status);
}