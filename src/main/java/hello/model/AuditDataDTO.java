package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuditDataDTO {
    
    @NotNull
    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("auditId")
    private Long auditId;

    @NotNull
    @Size(max = 255)
    @JsonProperty("recordDetails")
    private String recordDetails;

    @NotNull
    @Size(max = 255)
    @JsonProperty("action")
    private String action;

    @NotNull
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @NotNull
    @JsonProperty("userId")
    private Long userId;

    @Size(max = 500)
    @JsonProperty("details")
    private String details;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}