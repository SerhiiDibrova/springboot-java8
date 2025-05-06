package hello.controller;

import hello.model.ProductCreateRequest;
import hello.model.ProductDTO;
import hello.model.ProductResponse;
import hello.service.ProductService;
import hello.response.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getUserById(@PathVariable long id) {
        ProductDTO productDTO = service.getById(id);
        if(productDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createProduct(@Valid @RequestBody ProductCreateRequest request) {
        ProductResponse productResponse;
        try {
            productResponse = service.createProduct(request);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Internal Server Error"));
        }
        return ResponseUtil.successResponse(productResponse, "Product created successfully", 201, null);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listProducts() {
        List<ProductDTO> products;
        try {
            products = service.listProducts();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Internal Server Error"));
        }
        return ResponseUtil.successResponse(products, "Product list retrieved successfully", 200, null);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable UUID productId) {
        if (productId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        ProductResponse productResponse = service.getProductById(productId);
        if (productResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseUtil.successResponse(productResponse, "Product retrieved successfully", 200, null);
    }
}