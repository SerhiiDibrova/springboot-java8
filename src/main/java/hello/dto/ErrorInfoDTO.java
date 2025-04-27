package hello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfoDTO {
    private String errorMessage;
    private int errorSeverity;
    private int errorState;
}