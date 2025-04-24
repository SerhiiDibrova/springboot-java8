

package hello.model;

import java.time.LocalDateTime;

public class AuditEntity {
    private Long id;
    private Long auditId;
    private String recordDetails;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "AuditEntity{" +
                "id=" + id +
                ", auditId=" + auditId +
                ", recordDetails='" + recordDetails + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}