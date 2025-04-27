package hello.model;

import java.time.LocalDateTime;

public class AuditData {
    private Long id;
    private String details;
    private LocalDateTime createdAt;

    public AuditData(Long id, String details, LocalDateTime createdAt) {
        this.id = id;
        this.details = details;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}