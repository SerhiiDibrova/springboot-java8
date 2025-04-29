package hello.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ErrorLogDTO {
    @NotNull
    private String errorMessage;

    @NotNull
    private Integer errorSeverity;

    @NotNull
    private Integer errorState;

    public ErrorLogDTO(@NotNull String errorMessage, @NotNull Integer errorSeverity, @NotNull Integer errorState) {
        this.errorMessage = errorMessage;
        this.errorSeverity = errorSeverity;
        this.errorState = errorState;
    }

    public boolean isValid() {
        return errorMessage != null && errorSeverity != null && errorState != null;
    }
}