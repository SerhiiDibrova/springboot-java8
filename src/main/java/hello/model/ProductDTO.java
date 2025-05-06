package hello.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDTO {
    @NotNull
    private Long id;
    @NotNull
    @Size(max=255)
    private String name;
    @Size(max=500)
    private String description;

    // Constructors
    public ProductDTO() {
        this.id = 0L;
        this.name = "";
        this.description = null;
    }

    public ProductDTO(long id, String name) {
        this.id = id;
        this.name = name;
        this.description = null;
    }

    public ProductDTO(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}