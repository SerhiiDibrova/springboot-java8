package hello.repository;

import hello.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
    @Query("SELECT e FROM ErrorLog e WHERE e.errorSeverity = ?1")
    List<ErrorLog> findByErrorSeverity(Integer severity);
    Optional<ErrorLog> findById(Long id);
    List<ErrorLog> findAll();
}