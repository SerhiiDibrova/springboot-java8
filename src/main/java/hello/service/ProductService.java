package hello.service;

import hello.model.ProductDTO;
import hello.entity.ProductDB;
import hello.exception.ProductNotFoundException;
import hello.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getById(Long id) {
        return productRepository.findById(id)
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
        try {
            ProductDB productDB = new ProductDB();
            productDB.setName(productDTO.getName());
            productDB = productRepository.save(productDB);
            return new ProductDTO(productDB.getId(), productDB.getName());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating product", e);
        }
    }

    public ProductDTO getProductById(UUID productId) {
        return productRepository.findById(productId)
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + productId));
    }

    public List<ProductDTO> listAllProducts() {
        return productRepository.findAllByOrderByName()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    private ProductDTO convertToDTO(ProductDB productDB) {
        return new ProductDTO(productDB.getId(), productDB.getName());
    }
}