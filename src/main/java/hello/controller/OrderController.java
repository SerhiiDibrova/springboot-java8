package hello.controller;

import hello.model.OrderDTO;
import hello.service.OrderService;
import hello.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody @Valid OrderDTO orderDTO) {
        try {
            Map<String, Object> response = service.createOrder(orderDTO);
            return ResponseEntity.status(201).body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrder(@PathVariable UUID orderId) {
        if (orderId == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid UUID format"));
        }
        try {
            Map<String, Object> orderResponse = service.getOrder(orderId);
            return ResponseEntity.ok(orderResponse);
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> listOrders() {
        try {
            List<OrderDTO> orders = service.getAllOrders();
            return ResponseUtil.successResponse(orders, "Orders retrieved successfully", 200, null);
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Failed to retrieve orders", 500);
        }
    }
}