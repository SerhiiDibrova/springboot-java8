package hello.service;

import hello.model.ProductCreateRequest;
import hello.model.ProductDTO;
import hello.model.ProductResponse;
import hello.model.ProductDB;
import hello.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getById(UUID id) {
        return productRepository.findById(id)
                .map(item -> new ProductDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    public ProductResponse createProduct(ProductCreateRequest request) {
        ProductDB product = new ProductDB();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setInStock(request.getInStock());

        try {
            ProductDB savedProduct = productRepository.save(product);
            return mapToProductResponse(savedProduct);
        } catch (Exception e) {
            throw new ProductCreationException("Error creating product", e);
        }
    }

    public ProductResponse getProductById(UUID productId) {
        Optional<ProductDB> productDBOptional = productRepository.findById(productId);
        if (!productDBOptional.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        ProductDB productDB = productDBOptional.get();
        return mapToProductResponse(productDB);
    }

    private ProductResponse mapToProductResponse(ProductDB productDB) {
        ProductResponse response = new ProductResponse();
        response.setId(productDB.getId());
        response.setName(productDB.getName());
        response.setDescription(productDB.getDescription());
        response.setPrice(productDB.getPrice());
        response.setInStock(productDB.getInStock());
        return response;
    }

    public List<ProductDTO> listProducts() {
        return productRepository.findAllByOrderByName();
    }
}