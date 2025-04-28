package hello.controller;

import hello.model.OrderDTO;
import hello.model.OrderResponse;
import hello.model.OrderCreateRequest;
import hello.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable long id) {
        OrderResponse orderResponse = service.getById(id);
        if(orderResponse == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(orderResponse);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        OrderResponse orderResponse = service.createOrder(orderCreateRequest);
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> listOrders() {
        List<OrderResponse> orders = service.listOrders();
        return ResponseEntity.ok(orders);
    }
}