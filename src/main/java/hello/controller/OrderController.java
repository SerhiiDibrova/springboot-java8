package hello.controller;

import hello.model.OrderDTO;
import hello.model.OrderResponse;
import hello.model.OrderCreateRequest;
import hello.repository.OrderRepository;
import hello.service.OrderService;
import hello.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService service, OrderRepository orderRepository) {
        this.service = service;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable UUID id) {
        OrderDTO orderDTO = service.getById(id);
        if(orderDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(orderDTO);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        OrderResponse orderResponse = service.createOrder(orderCreateRequest);
        return ResponseEntity.ok(ResponseUtil.success_response(orderResponse));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable UUID orderId) {
        OrderResponse orderResponse = service.getOrder(orderId);
        if(orderResponse == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(ResponseUtil.success_response(orderResponse));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> listOrders() {
        try {
            List<OrderResponse> orders = orderRepository.findAllByOrderByCreatedAtDesc();
            return ResponseEntity.ok(ResponseUtil.success_response(orders));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ResponseUtil.error_response("Error retrieving orders"));
        }
    }
}