

package hello.model;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Component
public class Project {

    @Id
    private Long projectId;
    private String name;
    private LocalDate startDate;
    private Long departmentId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId) &&
                Objects.equals(name, project.name) &&
                Objects.equals(startDate, project.startDate) &&
                Objects.equals(departmentId, project.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, name, startDate, departmentId);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", departmentId=" + departmentId +
                '}';
    }
}