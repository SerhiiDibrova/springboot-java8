package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "default")
    private Byte defaultStatus;

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

    public Byte getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Byte defaultStatus) {
        this.defaultStatus = defaultStatus;
    }
}