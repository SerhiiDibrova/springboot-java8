package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String description;

    @NotNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotNull
    private Integer inStock;

    public ProductDB() {}

    public ProductDB(String name, String description, BigDecimal price, Integer inStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getInStock() {
        return inStock;
    }
    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDB)) return false;
        ProductDB other = (ProductDB) o;
        return id != null && id.equals(other.getId()) &&
               name != null && name.equals(other.getName()) &&
               price != null && price.equals(other.getPrice()) &&
               inStock != null && inStock.equals(other.getInStock());
    }

    @Override
    public int hashCode() {
        return 31 * (id != null ? id.hashCode() : 0) +
               31 * (name != null ? name.hashCode() : 0) +
               31 * (price != null ? price.hashCode() : 0) +
               31 * (inStock != null ? inStock.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', description='" + description + "', price=" + price + ", inStock=" + inStock + "}";
    }
}