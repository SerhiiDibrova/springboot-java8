package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "audit_data")
public class AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id", nullable = false)
    @NotNull
    private Long auditId;

    @Column(length = 255, name = "record_details", nullable = false)
    @NotNull
    @Size(max = 255)
    private String recordDetails;

    @Column(nullable = false, name = "created_at")
    @NotNull
    private LocalDateTime createdAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static void insertAuditData(EntityManager entityManager, List<AuditData> auditDataList) {
        for (AuditData auditData : auditDataList) {
            entityManager.persist(auditData);
        }
    }
}