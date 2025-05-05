package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "users")
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "default", nullable = false)
    private Integer defaultStatus = 0;

    public UserDB() {}

    public UserDB(String name, Integer roleId, Integer defaultStatus) {
        this.name = name;
        this.roleId = roleId;
        this.defaultStatus = defaultStatus;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }
    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDB)) return false;
        UserDB other = (UserDB) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', roleId=" + roleId + ", defaultStatus=" + defaultStatus + "}";
    }
}