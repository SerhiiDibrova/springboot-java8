package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuditDataDTO {

    @NotNull
    private Integer auditId;

    @NotNull
    @Size(max = 500)
    private String recordDetails;

    @NotNull
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    public AuditDataDTO() {
    }

    public AuditDataDTO(Integer auditId, String recordDetails, LocalDateTime createdAt) {
        this.auditId = auditId;
        this.recordDetails = recordDetails;
        this.createdAt = createdAt;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
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