

package hello.controller;

import hello.service.ComplexOperationService;
import hello.dto.ComplexOperationRequest;
import hello.dto.ComplexOperationResponse;
import hello.exception.ComplexOperationException;
import hello.exception.InvalidRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@RestController
@Slf4j
public class ComplexOperationController {

    private final ComplexOperationService complexOperationService;

    @Autowired
    public ComplexOperationController(ComplexOperationService complexOperationService) {
        this.complexOperationService = complexOperationService;
    }

    @PostMapping("/complex-operation")
    @Transactional
    public ResponseEntity<ComplexOperationResponse> performComplexOperation(@Valid @RequestBody ComplexOperationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Invalid request");
        }
        try {
            ComplexOperationResponse result = complexOperationService.performComplexOperation(request);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ComplexOperationException e) {
            log.error("Error performing complex operation", e);
            return new ResponseEntity<>(new ComplexOperationResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException e) {
        log.error("Invalid request", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("Internal server error", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}