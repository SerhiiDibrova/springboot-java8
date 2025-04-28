package hello.service;

import hello.entity.OrderDB;
import hello.entity.ProductDB;
import hello.dto.OrderDTO;
import hello.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Comparator;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public double computeTotal(OrderDB order) {
        if (order == null) {
            throw new IllegalArgumentException("Order must not be null");
        }
        double total = order.getProducts().stream()
                .mapToDouble(ProductDB::getPrice)
                .sum();
        if (total <= 0) {
            throw new IllegalArgumentException("Total must be greater than zero");
        }
        return total;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        OrderDB orderDB = new OrderDB();
        orderDB.setName(orderDTO.getName());
        // Set other properties from orderDTO to orderDB as needed
        OrderDB savedOrder = orderRepository.save(orderDB);
        return new OrderDTO(savedOrder.getId(), savedOrder.getName());
    }

    public OrderDTO getOrder(UUID orderId) {
        return orderRepository.findById(orderId)
                .map(item -> new OrderDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new CustomNotFoundException("Order not found with id " + orderId));
    }

    public List<OrderDTO> listOrders() {
        return orderRepository.findAll().stream()
                .sorted(Comparator.comparing(OrderDB::getCreationDate).reversed())
                .map(item -> new OrderDTO(item.getId(), item.getName()))
                .toList();
    }
}