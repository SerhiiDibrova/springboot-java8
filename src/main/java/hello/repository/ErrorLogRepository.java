package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import hello.entity.ErrorLog;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    List<ErrorLog> findByErrorSeverity(int severity);
    List<ErrorLog> findByErrorState(String state);
    List<ErrorLog> findByErrorMessageContaining(String message);
}