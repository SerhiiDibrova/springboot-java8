package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.io.Serializable;

public class ErrorLogDTO implements Serializable {

    @NotNull
    @Size(max = 255)
    @JsonProperty("errorMessage")
    private String errorMessage;

    @NotNull
    @Min(1)
    @Max(5)
    @JsonProperty("errorSeverity")
    private int errorSeverity;

    @NotNull
    @Min(0)
    @JsonProperty("errorState")
    private int errorState;

    public ErrorLogDTO() {
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
}