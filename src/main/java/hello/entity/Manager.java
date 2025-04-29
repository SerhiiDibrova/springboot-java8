package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    private Integer id;
    private Integer roleId;
    private Boolean defaultRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Boolean defaultRole) {
        this.defaultRole = defaultRole;
    }
}