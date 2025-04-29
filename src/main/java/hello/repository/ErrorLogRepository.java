package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import hello.entity.ErrorLog;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    Page<ErrorLog> findBySeverity(String severity, Pageable pageable);
    
    @Query("SELECT e FROM ErrorLog e WHERE e.message LIKE %:keyword%")
    Page<ErrorLog> searchByMessage(@Param("keyword") String keyword, Pageable pageable);
}