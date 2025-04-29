package hello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerIdDTO {
    @NotNull
    private Integer managerId;

    public boolean isValid() {
        return managerId != null && managerId > 0;
    }
}