package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "manager_id")
    private Integer managerId;

    @NotNull
    @Size(max = 50)
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "audit")
    private List<AuditRecord> auditRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
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