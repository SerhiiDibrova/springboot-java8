package hello.model;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Data
public class ProductDTO {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean inStock;

    // Constructors
    public ProductDTO() {}

    public ProductDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductDTO(UUID id, String name, String description, BigDecimal price, Boolean inStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    public ProductDTO(long id, String name, String description, BigDecimal price, Boolean inStock) {
        this.id = UUID.randomUUID(); // Assuming a new UUID is generated for the long id
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}