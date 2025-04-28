package hello.service;

import hello.model.OrderDTO;
import hello.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        OrderDB orderDB = new OrderDB();
        orderDB.setUserEmail(orderDTO.getUserEmail());
        orderDB.setProductIds(orderDTO.getProductIds());
        orderDB = orderRepository.save(orderDB);
        return new OrderDTO(orderDB.getId(), orderDB.getName());
    }

    public OrderDTO getOrder(UUID orderId) {
        return orderRepository.findById(orderId)
                .map(item -> new OrderDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id " + orderId));
    }

    public List<OrderDTO> listOrders() {
        try {
            return orderRepository.findAll().stream()
                    .map(item -> new OrderDTO(item.getId(), item.getName()))
                    .sorted(Comparator.comparing(OrderDTO::getCreationDate))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving orders", e);
        }
    }
}