package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    List<ErrorLog> findByErrorSeverity(int severity);
    List<ErrorLog> findAll();
}