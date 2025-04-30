package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.ErrorLog;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}