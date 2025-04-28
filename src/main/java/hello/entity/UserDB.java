package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "users")
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String value;

    // Default constructor required by JPA
    public UserDB() {}

    // Convenience constructor
    public UserDB(String name) {
        this.name = name;
    }

    // Overloaded constructor
    public UserDB(String email, String value) {
        this.email = email;
        this.value = value;
    }

    // Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    // Optional: equals/hashCode based on id
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

    // Optional: nice to have
    @Override
    public String toString() {
        return "User{id=" + id + ", email='" + email + "', value='" + value + "'}";
    }
}