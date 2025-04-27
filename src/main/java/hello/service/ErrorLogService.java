package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import hello.repository.ErrorLogRepository;
import hello.dto.ErrorLogDTO;
import hello.entity.ErrorLog;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Validated
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;
    private static final Logger logger = LoggerFactory.getLogger(ErrorLogService.class);

    @Autowired
    public ErrorLogService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void logError(@Valid ErrorLogDTO errorLogDTO) {
        try {
            ErrorLog errorLog = new ErrorLog();
            errorLog.setMessage(errorLogDTO.getMessage());
            errorLog.setTimestamp(errorLogDTO.getTimestamp());
            errorLog.setLevel(errorLogDTO.getLevel());
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            logger.error("Error while logging error: {}", e.getMessage());
            throw e;
        }
    }
}