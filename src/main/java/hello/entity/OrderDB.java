package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ElementCollection;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "order")
public class OrderDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userEmail;

    @ElementCollection
    @NotNull
    private List<Long> productIds = new ArrayList<>();

    @ElementCollection
    private List<ProductDB> products = new ArrayList<>();

    public OrderDB() {}

    public OrderDB(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Long> getProductIds() {
        return productIds;
    }
    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds != null ? productIds : new ArrayList<>();
    }

    public List<ProductDB> getProducts() {
        return products;
    }
    public void setProducts(List<ProductDB> products) {
        this.products = products != null ? products : new ArrayList<>();
    }

    public float compute_total() {
        float total = products.stream()
            .map(ProductDB::getPrice)
            .reduce(0f, Float::sum);
        if (total <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than 0");
        }
        return total;
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
        return 31;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", userEmail='" + userEmail + "', productIds=" + productIds + "}";
    }
}