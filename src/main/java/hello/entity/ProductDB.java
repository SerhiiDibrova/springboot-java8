package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class ProductDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 500)
    private String description;

    private Double price;

    private Boolean inStock;

    public ProductDB() {}

    public ProductDB(String name, String description, Double price, Boolean inStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDB)) return false;
        ProductDB other = (ProductDB) o;
        return id != null && id.equals(other.getId()) &&
               name != null && name.equals(other.getName()) &&
               description != null && description.equals(other.getDescription()) &&
               price != null && price.equals(other.getPrice()) &&
               inStock != null && inStock.equals(other.getInStock());
    }

    @Override
    public int hashCode() {
        return 31 * (id != null ? id.hashCode() : 0) +
               31 * (name != null ? name.hashCode() : 0) +
               31 * (description != null ? description.hashCode() : 0) +
               31 * (price != null ? price.hashCode() : 0) +
               31 * (inStock != null ? inStock.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', description='" + description + "', price=" + price + ", inStock=" + inStock + "}";
    }
}