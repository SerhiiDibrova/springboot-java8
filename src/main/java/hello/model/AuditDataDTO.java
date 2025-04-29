package hello.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

public class AuditDataDTO {
    @NotNull
    private Long auditId;
    
    @NotNull
    private String recordDetails;
    
    @NotNull
    private LocalDateTime createdAt;

    public AuditDataDTO(Long auditId, String recordDetails, LocalDateTime createdAt) {
        this.auditId = auditId;
        this.recordDetails = recordDetails;
        this.createdAt = createdAt;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public String getRecordDetails() {
        return recordDetails;
    }

    public void setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}