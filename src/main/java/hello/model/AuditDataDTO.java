package hello.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuditDataDTO {
    private int audit_id;

    @NotNull
    private int user_id;

    @NotNull
    private String action;

    @NotNull
    private LocalDateTime timestamp;

    @Size(max = 255)
    private String details;

    public int getAuditId() {
        return audit_id;
    }

    public void setAuditId(int audit_id) {
        this.audit_id = audit_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
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
}