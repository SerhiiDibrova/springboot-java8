package hello.service;

import hello.model.ProductDTO;
import hello.model.ProductListResponse;
import hello.model.ProductResponse;
import hello.repository.ProductRepository;
import hello.entity.ProductDB;
import hello.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse getProductById(UUID productId) {
        ProductDB product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + productId));
        return new ProductResponse(product.getId(), product.getName());
    }

    public ProductListResponse listAllProducts() {
        List<ProductDTO> products = productRepository.findAllByOrderByName()
                .stream()
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .collect(Collectors.toList());
        ProductListResponse response = new ProductListResponse();
        response.setProducts(products);
        return response;
    }
}