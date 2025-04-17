

package hello.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Table(name = "table_5")
public class Table5 {
    @Id
    private Integer id;
    private String name;
    private LocalDateTime createdAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}