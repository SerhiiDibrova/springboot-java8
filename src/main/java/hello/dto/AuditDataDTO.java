package hello.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditDataDTO {
    private Integer id;
    private Integer auditId;
    private Long audit_id;
    private String record_details;
    private LocalDateTime created_at;
}