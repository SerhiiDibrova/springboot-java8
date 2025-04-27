package hello.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ErrorLogDTO {
    @NotBlank
    private String errorMessage;

    @NotBlank
    @Size(max = 10)
    private String errorSeverity;

    @NotBlank
    private String errorState;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(String errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public String getErrorState() {
        return errorState;
    }

    public void setErrorState(String errorState) {
        this.errorState = errorState;
    }

    public void logError() {
        System.err.println("Error: " + errorMessage + ", Severity: " + errorSeverity + ", State: " + errorState);
    }
}