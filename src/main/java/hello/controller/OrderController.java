package hello.controller;

import hello.entity.OrderDB;
import hello.model.OrderDTO;
import hello.service.OrderService;
import hello.controller.ResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = service.createOrder(orderDTO);
        return ResponseController.success_response(createdOrder, "Order created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<?> getOrder(@PathVariable UUID order_id) {
        OrderDTO orderDTO = service.getOrder(order_id);
        return ResponseController.success_response(orderDTO, "Order retrieved successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listOrders() {
        List<OrderDTO> orders = service.listOrders();
        return ResponseController.success_response(orders, "Orders retrieved successfully", HttpStatus.OK);
    }
}