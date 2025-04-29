package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "users")
public class Manager {
    
    @Id
    @NotNull
    @Positive
    private Long id;

    @NotNull
    @Positive
    private Long roleId;

    private Boolean defaultStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Boolean getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Boolean defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", defaultStatus=" + defaultStatus +
                '}';
    }
}