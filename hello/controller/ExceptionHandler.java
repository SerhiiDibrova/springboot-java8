package hello.controller;

import hello.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@RestControllerAdvice
public class ExceptionHandler {

    private final Logger logger;

    @Autowired
    public ExceptionHandler(ApplicationContext applicationContext) {
        this.logger = Logger.getLogger(ExceptionHandler.class.getName());
    }

    @ExceptionHandler(value = {Exception.class, RequestValidationError.class})
    protected ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception exc) {
        logger.severe(exc.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(exc.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}