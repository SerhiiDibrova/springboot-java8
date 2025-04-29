package hello.dto;

import java.io.Serializable;

public class ManagerIdDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;

    public ManagerIdDTO() {
    }

    public ManagerIdDTO(Long id) {
        setId(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerIdDTO that = (ManagerIdDTO) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31 * (id != null ? id.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "ManagerIdDTO{" +
                "id=" + id +
                '}';
    }
}