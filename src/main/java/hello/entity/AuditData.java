package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_data", indexes = {@Index(name = "idx_created_at", columnList = "created_at")})
public class AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(unique = true)
    private String auditId;

    @NotNull
    @Column
    private String recordDetails;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    
    public static AuditData fromAuditRecord(String auditId, String recordDetails, LocalDateTime createdAt) {
        AuditData auditData = new AuditData();
        auditData.setAuditId(auditId);
        auditData.setRecordDetails(recordDetails);
        auditData.setCreatedAt(createdAt);
        return auditData;
    }
}