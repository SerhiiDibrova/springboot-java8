package hello.service;

import hello.model.OrderDTO;
import hello.model.OrderCreateRequest;
import hello.model.OrderResponse;
import hello.repository.OrderRepository;
import hello.model.OrderDB;
import hello.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderCreateRequest orderCreateRequest) {
        try {
            OrderDB orderDB = new OrderDB();
            orderDB.setName(orderCreateRequest.getName());
            orderDB = orderRepository.save(orderDB);
            return new OrderResponse(orderDB.getId(), orderDB.getName());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating the order", e);
        }
    }

    public OrderDTO getOrder(UUID orderId) {
        OrderDB orderDB = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + orderId));
        return convertToDTO(orderDB);
    }

    public List<OrderDTO> listOrders() {
        return orderRepository.findAllByOrderByCreationDateDesc().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO convertToDTO(OrderDB orderDB) {
        return new OrderDTO(orderDB.getId(), orderDB.getName());
    }
}