package hello.controller;

import hello.model.ProductDTO;
import hello.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    // Spring will auto-wire a bean of type UserService
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getUserById(@PathVariable long id) {
        ProductDTO productDTO = service.getById(id);
        if(productDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(productDTO);
    }
}
