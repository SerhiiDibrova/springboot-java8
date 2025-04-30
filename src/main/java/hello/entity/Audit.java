package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long managerId;

    @NotNull
    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "audit", cascade = CascadeType.ALL)
    private List<AuditRecord> auditRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AuditRecord> getAuditRecords() {
        return auditRecords;
    }

    public void setAuditRecords(List<AuditRecord> auditRecords) {
        this.auditRecords = auditRecords;
    }
}