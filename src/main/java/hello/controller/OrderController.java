package hello.controller;

import hello.model.OrderDTO;
import hello.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    // Spring will auto-wire a bean of type UserService
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getUserById(@PathVariable long id) {
        OrderDTO orderDTO = service.getById(id);
        if(orderDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(orderDTO);
    }
}
