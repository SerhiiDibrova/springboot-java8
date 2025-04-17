

package hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Entity representing a Proc1Entity.
 */
@Entity
@Table(name = "table_1")
public class Proc1Entity {

    /**
     * Unique identifier for the entity.
     */
    @Id
    private Integer id;

    /**
     * Name of the entity.
     */
    private String name;

    /**
     * Timestamp when the entity was created.
     */
    private LocalDateTime createdAt;

    /**
     * No-arg constructor required for JPA entities.
     */
    public Proc1Entity() {}

    /**
     * Gets the unique identifier for the entity.
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the entity.
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the entity.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the entity.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the timestamp when the entity was created.
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the timestamp when the entity was created.
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}