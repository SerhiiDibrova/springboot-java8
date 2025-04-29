package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ErrorLogDTO {

    @NotNull
    @Size(max = 255)
    @JsonProperty("errorMessage")
    private String errorMessage;

    @NotNull
    @JsonProperty("errorSeverity")
    private Integer errorSeverity;

    @NotNull
    @JsonProperty("errorState")
    private Integer errorState;

    public ErrorLogDTO() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(Integer errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public Integer getErrorState() {
        return errorState;
    }

    public void setErrorState(Integer errorState) {
        this.errorState = errorState;
    }
}