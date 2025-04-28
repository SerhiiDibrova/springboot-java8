package hello.controller;

import hello.model.OrderDTO;
import hello.model.OrderCreateRequest;
import hello.model.OrderResponse;
import hello.service.OrderService;
import hello.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final ResponseService responseService;

    public OrderController(OrderService service, ResponseService responseService) {
        this.service = service;
        this.responseService = responseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getUserById(@PathVariable long id) {
        OrderDTO orderDTO = service.getById(id);
        if(orderDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(orderDTO);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        OrderResponse orderResponse = service.createOrder(orderCreateRequest);
        return responseService.successResponse(orderResponse);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable UUID orderId) {
        OrderDTO orderDTO = service.getById(orderId);
        if(orderDTO == null) { return ResponseEntity.notFound().build(); }
        return responseService.successResponse(orderDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> listOrders() {
        List<OrderDTO> orders = service.listOrders();
        return responseService.successResponse(orders);
    }
}