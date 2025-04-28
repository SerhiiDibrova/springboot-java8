package hello.controller;

import hello.model.ProductDTO;
import hello.service.ProductService;
import hello.controller.ResponseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        service.createProduct(productDTO);
        return ResponseController.success_response("Product created successfully");
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<?> getProductById(@PathVariable UUID product_id) {
        ProductDTO productDTO = service.getProductById(product_id);
        if(productDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseController.success_response(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> listProducts() {
        List<ProductDTO> products = service.listAllProducts();
        return ResponseController.success_response(products);
    }
}