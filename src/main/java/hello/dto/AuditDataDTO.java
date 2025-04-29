package hello.dto;

import java.time.LocalDateTime;

public class AuditDataDTO {
    private String auditId;
    private String recordDetails;
    private LocalDateTime createdAt;
    private String id;

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isValid() {
        return auditId != null && !auditId.isEmpty() && 
               recordDetails != null && !recordDetails.isEmpty() && 
               createdAt != null && 
               id != null && !id.isEmpty();
    }

    @Override
    public String toString() {
        return "AuditDataDTO{" +
                "auditId='" + auditId + '\'' +
                ", recordDetails='" + recordDetails + '\'' +
                ", createdAt=" + createdAt +
                ", id='" + id + '\'' +
                '}';
    }
}