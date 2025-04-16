

package hello.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employee_projects")
@IdClass(EmployeeProjectId.class)
public class EmployeeProject {

    @Id
    private Long employeeId;
    @Id
    private Long projectId;
    private Date assignmentDate;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProject that = (EmployeeProject) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(projectId, that.projectId) &&
                Objects.equals(assignmentDate, that.assignmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectId, assignmentDate);
    }

    @Override
    public String toString() {
        return "EmployeeProject{" +
                "employeeId=" + employeeId +
                ", projectId=" + projectId +
                ", assignmentDate=" + assignmentDate +
                '}';
    }
}