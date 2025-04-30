package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ErrorLogRepository;

@Service
public class ErrorHandlingService {

    @Autowired
    private ErrorLogRepository errorLogRepository;

    public void handleError(Exception e) {
        String errorMessage = e.getMessage();
        int errorSeverity = 1;
        int errorState = 0;

        try {
            // Data access logic that may throw exceptions
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
            ErrorLog errorLog = new ErrorLog(errorMessage, errorSeverity, errorState);
            errorLogRepository.save(errorLog);
        }
    }
}