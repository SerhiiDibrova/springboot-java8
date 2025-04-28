package hello.service;

import hello.model.OrderDTO;
import hello.model.OrderResponse;
import hello.model.OrderCreateRequest;
import hello.exception.OrderException;
import hello.repository.OrderRepository;
import hello.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderCreateRequest request) {
        try {
            Order order = new Order(request.getName(), request.getDetails());
            Order savedOrder = orderRepository.save(order);
            return new OrderResponse(savedOrder.getId(), savedOrder.getName());
        } catch (Exception e) {
            throw new OrderException("Error creating order", e);
        }
    }

    public OrderResponse getOrderById(UUID orderId) {
        return orderRepository.findById(orderId)
                .map(order -> new OrderResponse(order.getId(), order.getName()))
                .orElseThrow(() -> new OrderException("Order not found with id " + orderId));
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .sorted((o1, o2) -> o2.getCreationDate().compareTo(o1.getCreationDate()))
                .map(item -> new OrderDTO(item.getId(), item.getName()))
                .collect(Collectors.toList());
    }
}