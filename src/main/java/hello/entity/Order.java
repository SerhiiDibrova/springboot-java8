package hello.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Order {

    @OneToMany
    private List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @javax.validation.Validator
    public void compute_total(Class<Order> cls, Double v, Map<String, Object> values) {
        List<Product> products = (List<Product>) values.getOrDefault("products", new ArrayList<>());
        double total = products.stream().mapToDouble(Product::getPrice).sum();
        if (total <= 0) {
            throw new IllegalArgumentException("Total must be greater than zero");
        }
    }
}