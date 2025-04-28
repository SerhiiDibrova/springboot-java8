package hello.service;

import hello.model.ProductDTO;
import hello.repository.ProductRepository;
import hello.entity.ProductDB;
import hello.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getById(Long id) {
        return productRepository.findById(id)
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

    public ProductDB createProduct(ProductCreateRequest request) {
        try {
            ProductDB product = new ProductDB();
            product.setName(request.getName());
            return productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error creating product", e);
        }
    }

    public ProductDTO getProductById(UUID productId) {
        return productRepository.findById(productId)
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .toList();
    }
}