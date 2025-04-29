package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true)
    private Integer roleId;

    @Column(nullable = true)
    private Boolean default = false;

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

    public Boolean getDefault() {
        return default;
    }

    public void setDefault(Boolean default) {
        this.default = default;
    }
}