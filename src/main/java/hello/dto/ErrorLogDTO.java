package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ErrorLogDTO {
    
    @NotNull
    @NotEmpty
    @JsonProperty("errorMessage")
    private String errorMessage;

    @NotNull
    @JsonProperty("errorSeverity")
    private Integer errorSeverity;

    @NotNull
    @JsonProperty("errorState")
    private Integer errorState;

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

    public ErrorLogEntity toEntity() {
        ErrorLogEntity entity = new ErrorLogEntity();
        entity.setErrorMessage(this.errorMessage);
        entity.setErrorSeverity(this.errorSeverity);
        entity.setErrorState(this.errorState);
        return entity;
    }
}