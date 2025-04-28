package hello.service;

import hello.model.OrderDTO;
import hello.model.OrderResponse;
import hello.model.OrderCreateRequest;
import hello.repository.OrderRepository;
import hello.exception.OrderNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final JdbcTemplate jdbcTemplate;

    public OrderService(OrderRepository orderRepository, JdbcTemplate jdbcTemplate) {
        this.orderRepository = orderRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public OrderDTO getById(Long id) {
        return orderRepository.findById(id)
                .map(item -> new OrderDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id));
    }

    public OrderResponse createOrder(OrderCreateRequest request) {
        try {
            String sql = "INSERT INTO orders (name, details) VALUES (?, ?) RETURNING id, name";
            return jdbcTemplate.queryForObject(sql, new Object[]{request.getName(), request.getDetails()},
                    (rs, rowNum) -> new OrderResponse(rs.getLong("id"), rs.getString("name")));
        } catch (Exception e) {
            throw new RuntimeException("Error creating order", e);
        }
    }

    public OrderResponse getOrderById(UUID orderId) {
        return orderRepository.findById(orderId)
                .map(item -> new OrderResponse(item.getId(), item.getName()))
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id " + orderId));
    }
}