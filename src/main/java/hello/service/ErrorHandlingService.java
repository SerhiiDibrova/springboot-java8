package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.dto.ErrorInfoDTO;
import hello.repository.ErrorInfoRepository;

@Service
public class ErrorHandlingService {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingService.class);

    @Autowired
    private ErrorInfoRepository errorInfoRepository;

    public void handleError(Exception e) {
        ErrorInfoDTO errorInfo = new ErrorInfoDTO();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setStackTrace(e.getStackTrace());
        logger.error("An error occurred: {}", e.getMessage(), e);
        errorInfoRepository.save(errorInfo);
    }
}