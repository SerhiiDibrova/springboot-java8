package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_record")
public class AuditRecord {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "audit_id", nullable = false)
    private Audit audit;

    @NotNull
    private String details;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
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