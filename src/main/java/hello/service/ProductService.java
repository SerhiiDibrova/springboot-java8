package hello.service;

import hello.model.ProductDTO;
import hello.repository.ProductRepository;
import hello.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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

    public ProductDTO createProduct(ProductDTO productDTO) {
        if (productDTO == null || productDTO.getName() == null || productDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name must not be null or empty");
        }
        ProductDB productDB = new ProductDB();
        productDB.setName(productDTO.getName());
        productDB = productRepository.save(productDB);
        return new ProductDTO(productDB.getId(), productDB.getName());
    }

    public ProductDTO getProduct(UUID productId) {
        return productRepository.findById(productId)
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .toList();
    }
}