package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.ErrorLog;
import org.springframework.dao.DataAccessException;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    default ErrorLog saveErrorLog(ErrorLog errorLog) {
        try {
            return save(errorLog);
        } catch (DataAccessException e) {
            // Log the exception (implementation of logging should be done here)
            throw e; // Rethrow or handle as needed
        }
    }
}