package hello.dto;

import javax.validation.constraints.NotBlank;

public class ErrorLogDTO {
    @NotBlank
    private String errorMessage;
    @NotBlank
    private String errorSeverity;
    @NotBlank
    private String errorState;

    public ErrorLogDTO(String errorMessage, String errorSeverity, String errorState) {
        if (errorMessage == null || errorMessage.trim().isEmpty()) {
            throw new IllegalArgumentException("errorMessage cannot be null or empty");
        }
        if (errorSeverity == null || errorSeverity.trim().isEmpty()) {
            throw new IllegalArgumentException("errorSeverity cannot be null or empty");
        }
        if (errorState == null || errorState.trim().isEmpty()) {
            throw new IllegalArgumentException("errorState cannot be null or empty");
        }
        this.errorMessage = errorMessage;
        this.errorSeverity = errorSeverity;
        this.errorState = errorState;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        if (errorMessage == null || errorMessage.trim().isEmpty()) {
            throw new IllegalArgumentException("errorMessage cannot be null or empty");
        }
        this.errorMessage = errorMessage;
    }

    public String getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(String errorSeverity) {
        if (errorSeverity == null || errorSeverity.trim().isEmpty()) {
            throw new IllegalArgumentException("errorSeverity cannot be null or empty");
        }
        this.errorSeverity = errorSeverity;
    }

    public String getErrorState() {
        return errorState;
    }

    public void setErrorState(String errorState) {
        if (errorState == null || errorState.trim().isEmpty()) {
            throw new IllegalArgumentException("errorState cannot be null or empty");
        }
        this.errorState = errorState;
    }
}