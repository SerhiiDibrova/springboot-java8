package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class Manager {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true)
    private Integer roleId;

    @NotNull
    @Column(name = "default_manager", nullable = false)
    private Boolean defaultManager;

    @ManyToOne
    private Role role;

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

    public Boolean getDefaultManager() {
        return defaultManager;
    }

    public void setDefaultManager(Boolean defaultManager) {
        this.defaultManager = defaultManager;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}