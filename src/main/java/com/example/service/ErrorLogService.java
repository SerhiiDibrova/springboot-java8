package com.example.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorLogService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void logError(String message, int severity, int state) {
        if (message == null || message.isEmpty() || severity < 0 || state < 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(message);
        errorLog.setErrorSeverity(severity);
        errorLog.setErrorState(state);
        errorLog.setTimestamp(LocalDateTime.now());
        try {
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            throw new RuntimeException("Failed to log error", e);
        }
    }
}