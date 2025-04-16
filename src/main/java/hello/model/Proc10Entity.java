

package hello.model;

import java.util.Date;

public class Proc10Entity {
    private Integer id;
    private String name;
    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        if (createdAt == null) {
            throw new NullPointerException("Created at date cannot be null");
        }
        if (createdAt.before(new Date())) {
            throw new IllegalArgumentException("Created at date cannot be in the past");
        }
        this.createdAt = createdAt;
    }
}