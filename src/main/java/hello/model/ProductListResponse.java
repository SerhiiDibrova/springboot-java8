package hello.model;

import java.util.List;
import hello.model.ProductDTO;

public class ProductListResponse {
    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}