package hello.service;

import hello.model.ProductDTO;
import hello.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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

    public ProductDTO getProduct(Long id) {
        try {
            ProductDTO product = this.getById(id);
            if (product != null) {
                return product;
            } else {
                throw new EntityNotFoundException("Product not found with id " + id);
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Product not found with id " + id, e);
        }
    }
}