package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users", indexes = {@Index(name = "idx_role_id", columnList = "role_id")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @NotNull
    @Column(name = "default_user", nullable = false, columnDefinition = "boolean default false")
    private Boolean defaultUser;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getDefaultUser() {
        return defaultUser;
    }

    public void setDefaultUser(Boolean defaultUser) {
        this.defaultUser = defaultUser;
    }

    public static User findDefaultManager(EntityManager em) {
        return em.createQuery("SELECT u FROM User u WHERE u.defaultUser = true", User.class)
                 .setMaxResults(1)
                 .getSingleResult();
    }
}