package hello.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AuditDataDTO {
    private Integer id;
    private Integer auditId;
    private String recordDetails;
    private String action;
    private String userId;
    private Timestamp timestamp;
    private LocalDateTime createdAt;

    public AuditDataDTO(Integer id, Integer auditId, String recordDetails, String action, String userId, Timestamp timestamp, LocalDateTime createdAt) {
        this.id = id;
        this.auditId = auditId;
        this.recordDetails = recordDetails;
        this.action = action;
        this.userId = userId;
        this.timestamp = timestamp;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}