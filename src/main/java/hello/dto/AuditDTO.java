package hello.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditDTO {
    private Integer id;
    private String details;
    private LocalDateTime createdAt;
}