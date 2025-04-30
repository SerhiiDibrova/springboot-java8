package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "audit_data")
public class AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "audit_id")
    private Integer auditId;

    @NotNull
    @Column(name = "record_details", columnDefinition = "NVARCHAR(MAX)")
    private String recordDetails;

    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @SqlResultSetMapping(
        name = "AuditDataMapping",
        entities = @EntityResult(entityClass = AuditData.class)
    )
    @NamedNativeQuery(
        name = "AuditData.populate",
        query = "INSERT INTO audit_data (audit_id, record_details, created_at) " +
                "SELECT ar.audit_id, ar.record_details, GETDATE() " +
                "FROM audit a " +
                "JOIN audit_record ar ON a.id = ar.audit_id " +
                "WHERE a.manager_id = :managerId AND a.type = 'SALES'",
        resultSetMapping = "AuditDataMapping"
    )
}