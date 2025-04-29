package hello.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuditDataDTO {
    
    @JsonProperty("auditId")
    @NotNull
    private String auditId;
    
    @JsonProperty("recordDetails")
    @NotNull
    private String recordDetails;
    
    @JsonProperty("createdAt")
    @NotNull
    private LocalDateTime createdAt;
    
    @JsonProperty("action")
    @NotNull
    private String action;
    
    @JsonProperty("userId")
    @NotNull
    private String userId;
    
    @JsonProperty("timestamp")
    @NotNull
    private LocalDateTime timestamp;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}