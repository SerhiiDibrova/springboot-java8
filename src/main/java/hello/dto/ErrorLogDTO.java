package hello.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;

@Getter
@Setter
public class ErrorLogDTO {
    @NotEmpty
    private String errorMessage;

    @Min(1)
    private Integer errorSeverity;

    @Min(0)
    private Integer errorState;

    public ErrorLogEntity toEntity() {
        ErrorLogEntity entity = new ErrorLogEntity();
        entity.setErrorMessage(this.errorMessage);
        entity.setErrorSeverity(this.errorSeverity);
        entity.setErrorState(this.errorState);
        return entity;
    }
}