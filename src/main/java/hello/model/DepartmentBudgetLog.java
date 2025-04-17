

package hello.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "DepartmentBudgetLog")
public class DepartmentBudgetLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column
    private Long deptId;

    @Column
    private Double oldBudget;

    @Column
    private Double newBudget;

    @Column
    private LocalDateTime timestamp;

    public DepartmentBudgetLog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Double getOldBudget() {
        return oldBudget;
    }

    public void setOldBudget(Double oldBudget) {
        this.oldBudget = oldBudget;
    }

    public Double getNewBudget() {
        return newBudget;
    }

    public void setNewBudget(Double newBudget) {
        this.newBudget = newBudget;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        if (timestamp == null) {
            throw new NullPointerException("Timestamp cannot be null");
        }
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "DepartmentBudgetLog{" +
                "id=" + id +
                ", deptId=" + deptId +
                ", oldBudget=" + oldBudget +
                ", newBudget=" + newBudget +
                ", timestamp=" + timestamp +
                '}';
    }
}