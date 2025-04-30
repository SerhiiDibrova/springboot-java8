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
    private Integer id;

    @NotNull
    @Column(name = "manager_id")
    private Integer managerId;

    @NotNull
    @Size(max = 50)
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "audit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuditRecord> auditRecords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void insertAuditData(Integer managerId, String type) {
        this.managerId = managerId;
        this.type = type;
    }
}