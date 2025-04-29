package hello.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ErrorLogDTO {
    
    @NotNull
    private String errorMessage;

    @NotNull
    @Min(1)
    private int errorSeverity;

    @NotNull
    @Min(1)
    private int errorState;

    public ErrorLogDTO() {
    }

    public ErrorLogDTO(String errorMessage, int errorSeverity, int errorState) {
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

    public int getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(int errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public int getErrorState() {
        return errorState;
    }

    public void setErrorState(int errorState) {
        this.errorState = errorState;
    }

    public ErrorLog toEntity() {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorMessage(this.errorMessage);
        errorLog.setErrorSeverity(this.errorSeverity);
        errorLog.setErrorState(this.errorState);
        return errorLog;
    }

    public static ErrorLogDTO fromEntity(ErrorLog errorLog) {
        return new ErrorLogDTO(errorLog.getErrorMessage(), errorLog.getErrorSeverity(), errorLog.getErrorState());
    }
}