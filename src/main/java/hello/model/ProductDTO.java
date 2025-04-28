package hello.model;

import lombok.Data;

@Data
public class ProductDTO {
    private long id;
    private String name;
    private String description;
    private double price;
    private boolean in_stock;

    // Constructors
    public ProductDTO() {}

    public ProductDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductDTO(long id, String name, String description, double price, boolean in_stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.in_stock = in_stock;
    }
}