package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuditDataDTO {
    
    @NotNull
    private Long auditId;

    @Size(max = 255)
    private String recordDetails;

    @NotNull
    private LocalDateTime createdAt;

    public AuditDataDTO() {
        this.createdAt = LocalDateTime.now();
    }

    @JsonProperty("auditId")
    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    @JsonProperty("recordDetails")
    public String getRecordDetails() {
        return recordDetails;
    }

    public void setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
    }

    @JsonProperty("createdAt")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}