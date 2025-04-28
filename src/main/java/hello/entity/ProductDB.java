package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "product")
public class ProductDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private float price;

    public ProductDB() {}

    public ProductDB(String name) {
        this.name = name;
    }

    public ProductDB(String name, float price) {
        this.name = name;
        this.price = price;
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

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDB)) return false;
        ProductDB other = (ProductDB) o;
        return id != null && id.equals(other.getId()) && price == other.price;
    }

    @Override
    public int hashCode() {
        return 31 * (id != null ? id.hashCode() : 0) + Float.floatToIntBits(price);
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
}