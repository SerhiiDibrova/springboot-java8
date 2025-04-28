package hello.controller;

import hello.model.ProductDTO;
import hello.model.ProductCreateRequest;
import hello.service.ProductService;
import hello.controller.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductCreateRequest request) {
        ProductDTO productDTO = service.createProduct(request);
        return ResponseUtil.success_response(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable UUID product_id) {
        ProductDTO productDTO = service.getProductById(product_id);
        return ResponseUtil.success_response(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> listProducts() {
        List<ProductDTO> products = service.listProducts();
        return ResponseUtil.success_response(products);
    }
}