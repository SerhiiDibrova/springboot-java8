package hello.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderDB {
    private List<ProductDB> products;

    public OrderDB() {
        this.products = new ArrayList<>();
    }

    public List<ProductDB> getProducts() {
        return new ArrayList<>(products);
    }

    public void setProducts(List<ProductDB> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty");
        }
        this.products = new ArrayList<>(products);
    }

    public void addProduct(ProductDB product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public void removeProduct(ProductDB product) {
        products.remove(product);
    }
}