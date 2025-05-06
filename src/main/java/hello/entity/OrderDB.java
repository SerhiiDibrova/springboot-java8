package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull
    @Column(nullable = false)
    private Double total_amount;

    @OneToMany(mappedBy = "order")
    private List<ProductDB> products = new ArrayList<>();

    public OrderDB() {}

    public OrderDB(String name) {
        this.name = name;
        this.products = new ArrayList<>();
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

    public Double getTotalAmount() {
        return total_amount;
    }
    public void setTotalAmount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public List<ProductDB> getProducts() {
        return products;
    }
    public void setProducts(List<ProductDB> products) {
        this.products = products;
        compute_total();
    }

    public void compute_total() {
        double total = products.stream().mapToDouble(ProductDB::getPrice).sum();
        if (total <= 0) {
            throw new IllegalArgumentException("Total amount must be greater than zero.");
        }
        this.total_amount = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDB)) return false;
        OrderDB other = (OrderDB) o;
        return id != null && id.equals(other.getId()) && total_amount != null && total_amount.equals(other.getTotalAmount());
    }

    @Override
    public int hashCode() {
        return 31 * (id != null ? id.hashCode() : 0) + (total_amount != null ? total_amount.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", name='" + name + "', total_amount=" + total_amount + "}";
    }
}