package hello.controller;

import hello.model.OrderDTO;
import hello.service.OrderService;
import hello.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getUserById(@PathVariable long id) {
        OrderDTO orderDTO = service.getById(id);
        if(orderDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(orderDTO);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = service.createOrder(orderDTO);
        return ResponseUtil.success_response(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable UUID orderId) {
        OrderDTO orderDTO = service.getOrder(orderId);
        return ResponseUtil.success_response(orderDTO, "Order retrieved successfully", HttpStatus.OK, null);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> listOrders() {
        List<OrderDTO> orders = service.listOrders();
        return ResponseUtil.success_response(orders, "Orders retrieved successfully", HttpStatus.OK, null);
    }
}