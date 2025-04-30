package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "error_log")
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 500)
    @Column(length = 500)
    private String errorMessage;

    @NotNull
    @Column
    private Integer errorSeverity;

    @NotNull
    @Column
    private Integer errorState;

    @NotNull
    @Column(updatable = false)
    private LocalDateTime timestamp;

    public ErrorLog() {
        this.timestamp = LocalDateTime.now();
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

package com.example.repository;

import com.example.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}

package com.example.service;

import com.example.entity.ErrorLog;
import com.example.repository.ErrorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorLogService {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void save(ErrorLog errorLog) {
        errorLogRepository.save(errorLog);
    }
}