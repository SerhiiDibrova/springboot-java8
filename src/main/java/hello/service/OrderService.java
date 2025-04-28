package hello.service;

import hello.model.OrderDTO;
import hello.repository.OrderRepository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDTO getById(Long id) {
        return orderRepository.findById(id)
                .map(item -> new OrderDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id));
    }
}

