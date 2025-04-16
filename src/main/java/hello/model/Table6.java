

package hello.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Entity6 {
    private Long id;
    private String name;
    private LocalDateTime created_at;

    public Entity6() {}

    public Entity6(Long id, String name, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
    }

    public Entity6(String name, LocalDateTime created_at) {
        this.name = name;
        this.created_at = created_at;
    }

    public Entity6(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Entity6(Long id, LocalDateTime created_at) {
        this.id = id;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity6 entity6 = (Entity6) o;
        return Objects.equals(id, entity6.id) &&
                Objects.equals(name, entity6.name) &&
                Objects.equals(created_at, entity6.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created_at);
    }

    @Override
    public String toString() {
        return "Entity6{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}