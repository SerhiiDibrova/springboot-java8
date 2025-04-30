package hello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorLogRequest {
    @NotNull
    private String errorMessage;
    
    @NotNull
    private int errorSeverity;
    
    @NotNull
    private int errorState;
}