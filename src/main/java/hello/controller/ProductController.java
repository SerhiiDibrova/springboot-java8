package hello.controller;

import hello.model.ProductCreateRequest;
import hello.model.ProductDTO;
import hello.model.ProductListResponse;
import hello.model.ProductResponse;
import hello.service.ProductService;
import hello.util.ResponseUtil;
import hello.repository.ProductRepository;
import hello.entity.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final ProductRepository repository;

    public ProductController(ProductService service, ProductRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductCreateRequest request) {
        ProductResponse response = service.createProduct(request);
        return ResponseUtil.success_response(response);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable UUID product_id) {
        try {
            ProductResponse response = service.getProductById(product_id);
            return ResponseUtil.success_response(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<ProductListResponse> listProducts() {
        ProductListResponse response = service.listAllProducts();
        return ResponseUtil.success_response(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getUserById(@PathVariable long id) {
        ProductDTO productDTO = service.getById(id);
        if(productDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(productDTO);
    }
}