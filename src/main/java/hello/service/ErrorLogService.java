package hello.service;

import hello.repository.ErrorLogRepository;
import hello.entity.ErrorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorLogService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void logError(String errorMessage, String errorSeverity, String errorState) {
        try {
            ErrorLog errorLog = new ErrorLog();
            errorLog.setErrorMessage(errorMessage);
            errorLog.setErrorSeverity(errorSeverity);
            errorLog.setErrorState(errorState);
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            // Exception handling will be managed by GlobalExceptionHandler
            throw e;
        }
    }
}