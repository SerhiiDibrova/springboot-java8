package hello.controller;

import hello.model.ProductCreateRequest;
import hello.model.ProductDTO;
import hello.model.ProductListResponse;
import hello.model.ProductResponse;
import hello.service.ProductService;
import hello.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final ResponseService responseService;

    public ProductController(ProductService service, ResponseService responseService) {
        this.service = service;
        this.responseService = responseService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductCreateRequest request) {
        ProductResponse productResponse = service.createProduct(request);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID product_id) {
        ProductResponse productResponse = service.getProductById(product_id);
        return responseService.success_response(productResponse);
    }

    @GetMapping
    public ResponseEntity<ProductListResponse> listProducts() {
        ProductListResponse productListResponse = service.listProducts();
        return ResponseEntity.ok(productListResponse);
    }
}