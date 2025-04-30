package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @NotNull
    @Column(name = "default_manager", nullable = false)
    private Boolean defaultManager;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
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

    public static List<User> findByRoleId(EntityManager em, Integer roleId) {
        return em.createQuery("SELECT u FROM User u WHERE u.roleId = :roleId", User.class)
                 .setParameter("roleId", roleId)
                 .getResultList();
    }
}