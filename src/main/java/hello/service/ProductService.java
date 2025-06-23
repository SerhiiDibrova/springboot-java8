package hello.service;

import hello.model.ProductDTO;
import hello.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .collect(Collectors.toList());
    }
}