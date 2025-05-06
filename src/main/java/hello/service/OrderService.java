package hello.service;

import hello.model.OrderDTO;
import hello.model.OrderDB;
import hello.model.OrderResponse;
import hello.repository.OrderRepository;
import hello.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public ResponseEntity<Map<String, Object>> createOrder(OrderDTO orderDTO) {
        OrderDB orderEntity = orderDTO.toEntity();
        try {
            OrderDB createdOrder = orderRepository.save(orderEntity);
            return ResponseUtil.successResponse(createdOrder, "Order created successfully", HttpStatus.CREATED.value(), null);
        } catch (Exception e) {
            return ResponseUtil.errorResponse("Error creating order", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    public OrderResponse getOrder(UUID orderId) {
        OrderDB order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return new OrderResponse(order);
    }

    public List<OrderDB> getAllOrders() {
        try {
            return orderRepository.findAllByOrderByCreatedAtDesc();
        } catch (Exception e) {
            throw new CustomDatabaseException("Error retrieving orders", e);
        }
    }
}