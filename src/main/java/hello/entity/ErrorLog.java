package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String errorMessage;

    @Column(nullable = false)
    private Integer errorSeverity;

    @Column(nullable = false)
    private Integer errorState;

    public ErrorLog() {
    }

    public ErrorLog(String errorMessage, Integer errorSeverity, Integer errorState) {
        this.errorMessage = errorMessage;
        this.errorSeverity = errorSeverity;
        this.errorState = errorState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(Integer errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public Integer getErrorState() {
        return errorState;
    }

    public void setErrorState(Integer errorState) {
        this.errorState = errorState;
    }
}

package hello.repository;

import hello.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}

package hello.service;

import hello.entity.ErrorLog;
import hello.repository.ErrorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorLogService {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void logError(String errorMessage, Integer errorSeverity, Integer errorState) {
        ErrorLog errorLog = new ErrorLog(errorMessage, errorSeverity, errorState);
        errorLogRepository.save(errorLog);
    }
}

package hello.controller;

import hello.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorLogController {

    @Autowired
    private ErrorLogService errorLogService;

    @PostMapping("/logError")
    public void logError(@RequestBody ErrorLogRequest errorLogRequest) {
        errorLogService.logError(errorLogRequest.getErrorMessage(), errorLogRequest.getErrorSeverity(), errorLogRequest.getErrorState());
    }
}

class ErrorLogRequest {
    private String errorMessage;
    private Integer errorSeverity;
    private Integer errorState;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(Integer errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public Integer getErrorState() {
        return errorState;
    }

    public void setErrorState(Integer errorState) {
        this.errorState = errorState;
    }
}