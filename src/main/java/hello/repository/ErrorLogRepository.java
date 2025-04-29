package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.ErrorLog;
import java.util.List;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    List<ErrorLog> findByErrorSeverity(String errorSeverity);
    List<ErrorLog> findByErrorState(String errorState);
}