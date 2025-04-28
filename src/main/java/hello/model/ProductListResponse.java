package hello.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListResponse {
    private List<ProductDTO> products = new ArrayList<>();

    public List<ProductDTO> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void setProducts(List<ProductDTO> products) {
        if (products != null) {
            this.products.clear();
            this.products.addAll(products);
        }
    }

    public void addProduct(ProductDTO product) {
        if (product != null) {
            this.products.add(product);
        }
    }

    public void removeProduct(ProductDTO product) {
        this.products.remove(product);
    }

    public void clearProducts() {
        this.products.clear();
    }
}