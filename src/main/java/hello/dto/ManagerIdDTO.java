package hello.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Null;

@Getter
@Setter
public class ManagerIdDTO {
    @Null
    private Integer managerId;

    @Null
    private Integer defaultManagerId;
}