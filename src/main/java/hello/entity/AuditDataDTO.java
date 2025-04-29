package hello.entity;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class AuditDataDTO {
    private Long id;

    @NotNull
    @Size(min = 1)
    private String auditId;

    @NotNull
    @Size(min = 1)
    private String recordDetails;

    @NotNull
    private LocalDateTime timestamp;
}