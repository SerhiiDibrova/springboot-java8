package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class AuditDataDTO {
    @JsonProperty("auditId")
    private Long auditId;

    @JsonProperty("recordDetails")
    private String recordDetails;

    @JsonProperty("createdAt")
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