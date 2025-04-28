package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "product")
public class ProductDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "in_stock")
    private int inStock;

    public ProductDB() {}

    public ProductDB(String name, String description, float price, int inStock) {
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

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDB)) return false;
        ProductDB other = (ProductDB) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', description='" + description + "', price=" + price + ", inStock=" + inStock + "}";
    }
}