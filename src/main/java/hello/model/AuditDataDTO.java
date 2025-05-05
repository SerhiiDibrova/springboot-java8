package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

public class AuditDataDTO implements Serializable {

    @NotNull
    private Long audit_id;

    @NotNull
    private int user_id;

    @Size(max = 255)
    private String action;

    @NotNull
    private LocalDateTime timestamp;

    @Size(max = 500)
    @JsonProperty("recordDetails")
    private String details;

    @NotNull
    @JsonProperty("createdAt")
    private LocalDateTime created_at;

    public AuditDataDTO(@NotNull Long auditId, @NotNull int userId, @Size(max = 255) String action, 
                        @NotNull LocalDateTime timestamp, @Size(max = 500) String details, 
                        @NotNull LocalDateTime createdAt) {
        this.audit_id = auditId;
        this.user_id = userId;
        this.action = action;
        this.timestamp = timestamp;
        this.details = details;
        this.created_at = createdAt;
    }

    public Long getAuditId() {
        return audit_id;
    }

    public void setAuditId(Long auditId) {
        this.audit_id = auditId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.created_at = createdAt;
    }
}