package hello.controller;

import hello.model.ProductDTO;
import hello.service.ProductService;
import hello.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final ResponseService responseService;

    @Autowired
    public ProductController(ProductService service, ResponseService responseService) {
        this.service = service;
        this.responseService = responseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getUserById(@PathVariable long id) {
        ProductDTO productDTO = service.getById(id);
        if(productDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = service.createProduct(productDTO);
        return responseService.successResponse(createdProduct);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable UUID product_id) {
        ProductDTO productDTO = service.getProduct(product_id);
        return responseService.successResponse(productDTO);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listProducts() {
        List<ProductDTO> products = service.listProducts();
        return responseService.successResponse(products);
    }
}