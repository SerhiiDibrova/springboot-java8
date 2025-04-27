package hello.declaration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataAccessException;
import javax.persistence.EntityNotFoundException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final ErrorLogService errorLogService;

    public GlobalExceptionHandler(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorLogDTO> handleDataAccessException(DataAccessException ex) {
        ErrorLogDTO errorLog = new ErrorLogDTO(ex.getMessage());
        errorLogService.logError(errorLog);
        return new ResponseEntity<>(errorLog, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorLogDTO> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorLogDTO errorLog = new ErrorLogDTO(ex.getMessage());
        errorLogService.logError(errorLog);
        return new ResponseEntity<>(errorLog, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SAXParseException.class)
    public ResponseEntity<ErrorLogDTO> handleXmlParseException(SAXParseException ex) {
        ErrorLogDTO errorLog = new ErrorLogDTO(ex.getMessage());
        errorLogService.logError(errorLog);
        return new ResponseEntity<>(errorLog, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorLogDTO> handleException(Exception ex) {
        ErrorLogDTO errorLog = new ErrorLogDTO(ex.getMessage());
        errorLogService.logError(errorLog);
        return new ResponseEntity<>(errorLog, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}