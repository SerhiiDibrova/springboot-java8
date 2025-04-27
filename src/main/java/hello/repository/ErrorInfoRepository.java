package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.ErrorInfo;

public interface ErrorInfoRepository extends JpaRepository<ErrorInfo, Long> {
}