

package hello.model;

import java.lang.Long;
import java.lang.Double;
import java.util.Date;

public class DepartmentBudgetLog {
    private Long id;
    private Long departmentId;
    private Double oldBudget;
    private Double newBudget;
    private Date changeDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}