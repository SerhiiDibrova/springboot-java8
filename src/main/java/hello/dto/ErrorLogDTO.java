package hello.dto;

import javax.validation.constraints.NotBlank;

public class ErrorLogDTO {
    @NotBlank
    private String errorMessage;
    
    @NotBlank
    private String errorSeverity;
    
    @NotBlank
    private String errorState;

    public ErrorLogDTO() {
    }

    public ErrorLogDTO(String errorMessage, String errorSeverity, String errorState) {
        this.errorMessage = errorMessage;
        this.errorSeverity = errorSeverity;
        this.errorState = errorState;
    }

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
}