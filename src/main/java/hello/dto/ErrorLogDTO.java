package hello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorLogDTO {
    @NotNull
    private String errorMessage;

    @NotNull
    private int errorSeverity;

    @NotNull
    private int errorState;
}