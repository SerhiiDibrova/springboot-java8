package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "order")
public class OrderDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<ProductDB> products;

    public OrderDB() {}

    public OrderDB(String name) {
        this.name = name;
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

    public List<ProductDB> getProducts() {
        return products;
    }
    public void setProducts(List<ProductDB> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDB)) return false;
        OrderDB other = (OrderDB) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return 31 * (id != null ? id.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", name='" + name + "'}";
    }
}