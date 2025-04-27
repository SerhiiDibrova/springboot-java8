package hello.dto;

import java.time.LocalDateTime;

public class AuditDataDTO {
    private Integer id;
    private String action;
    private LocalDateTime timestamp;
    private String userId;
    private String details;

    public AuditDataDTO() {
    }

    public AuditDataDTO(Integer id, String action, LocalDateTime timestamp, String userId, String details) {
        this.id = id;
        this.action = action;
        this.timestamp = timestamp;
        this.userId = userId;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}