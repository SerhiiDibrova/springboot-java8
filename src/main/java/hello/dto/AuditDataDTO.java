package hello.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class AuditDataDTO {
    
    @NotNull
    private Long auditId;
    
    @JsonProperty
    private String recordDetails;
    
    @NotNull
    private LocalDateTime createdAt;
    
    @NotNull
    private Long id;
    
    @NotNull
    private LocalDateTime timestamp;

    public AuditDataDTO() {
    }

    public AuditDataDTO(Long auditId, String recordDetails, LocalDateTime createdAt, Long id, LocalDateTime timestamp) {
        this.auditId = auditId;
        this.recordDetails = recordDetails;
        this.createdAt = createdAt;
        this.id = id;
        this.timestamp = timestamp;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}