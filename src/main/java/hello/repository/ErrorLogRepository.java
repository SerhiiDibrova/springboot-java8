package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.ErrorLog;
import java.util.Optional;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    Optional<ErrorLog> findById(Long id);
    void deleteById(Long id);
    List<ErrorLog> findAll();
    ErrorLog save(ErrorLog errorLog);
}