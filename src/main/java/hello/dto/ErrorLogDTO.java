package hello.dto;

public class ErrorLogDTO {
    private String errorMessage;
    private int errorSeverity;
    private int errorState;

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
}