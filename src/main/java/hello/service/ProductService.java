package hello.service;

import hello.model.ProductCreateRequest;
import hello.model.ProductResponse;
import hello.model.ProductListResponse;
import hello.entity.ProductDB;
import hello.exception.ProductNotFoundException;
import hello.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductCreateRequest request) {
        ProductDB product = new ProductDB();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        try {
            productRepository.save(product);
            return new ProductResponse(product.getId(), product.getName());
        } catch (Exception e) {
            throw new RuntimeException("Error creating product", e);
        }
    }

    public ProductResponse getProduct(UUID productId) {
        return productRepository.findById(productId)
                .map(item -> new ProductResponse(item.getId(), item.getName()))
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + productId));
    }

    public ProductListResponse listAllProducts() {
        List<ProductDB> products = productRepository.findAllByOrderByName();
        return new ProductListResponse(products.stream()
                .map(item -> new ProductResponse(item.getId(), item.getName()))
                .toList());
    }
}