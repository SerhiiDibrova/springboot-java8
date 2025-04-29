package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class AuditDataDTO {

    @NotNull
    @JsonProperty("auditId")
    private Integer auditId;

    @Size(max = 255)
    @JsonProperty("recordDetails")
    private String recordDetails;

    @NotNull
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @NotNull
    @JsonProperty("action")
    private String action;

    public static AuditDataDTO fromEntity(AuditData entity) {
        AuditDataDTO dto = new AuditDataDTO();
        dto.setAuditId(entity.getAuditId());
        dto.setRecordDetails(entity.getRecordDetails());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setAction(entity.getAction());
        return dto;
    }

    public AuditData toEntity() {
        AuditData entity = new AuditData();
        entity.setAuditId(this.auditId);
        entity.setRecordDetails(this.recordDetails);
        entity.setCreatedAt(this.createdAt);
        entity.setAction(this.action);
        return entity;
    }
}