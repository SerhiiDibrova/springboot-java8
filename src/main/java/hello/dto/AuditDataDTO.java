package hello.dto;

import java.time.LocalDateTime;

public class AuditDataDTO {
    private String id;
    private String action;
    private String userId;
    private LocalDateTime timestamp;

    public AuditDataDTO(String id, String action, String userId, LocalDateTime timestamp) {
        this.id = id;
        this.action = action;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String toString() {
        return "AuditDataDTO{" +
                "id='" + id + '\'' +
                ", action='" + action + '\'' +
                ", userId='" + userId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}