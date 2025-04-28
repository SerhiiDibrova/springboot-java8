package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;
import java.util.Objects;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order")
public class OrderDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private List<ProductDB> products;
    private List<Long> productIds;

    // Default constructor required by JPA
    public OrderDB() {}

    // Convenience constructor
    public OrderDB(String userEmail, List<ProductDB> products, List<Long> productIds) {
        this.userEmail = userEmail;
        this.products = products;
        this.productIds = productIds;
    }

    // Getters & Setters
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

    public List<ProductDB> getProducts() {
        return products;
    }
    public void setProducts(List<ProductDB> products) {
        this.products = products;
    }

    public List<Long> getProductIds() {
        return productIds;
    }
    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    @NotNull
    public double computeTotal() {
        if (products == null) {
            products = List.of();
        }
        double total = products.stream().mapToDouble(ProductDB::getPrice).sum();
        if (total <= 0) {
            throw new ValidationException("Total price must be greater than zero.");
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDB)) return false;
        OrderDB other = (OrderDB) o;
        return id != null && id.equals(other.getId()) && Objects.equals(userEmail, other.userEmail) && Objects.equals(products, other.products) && Objects.equals(productIds, other.productIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEmail, products, productIds);
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", userEmail='" + userEmail + "', productIds=" + productIds + "}";
    }
}