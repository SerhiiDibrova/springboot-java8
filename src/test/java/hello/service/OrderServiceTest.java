package hello.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import hello.model.Order;
import hello.repository.OrderRepository;
import hello.exception.InvalidOrderException;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOrder_ValidOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setProduct("Product A");
        order.setQuantity(2);

        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertNotNull(createdOrder);
        assertEquals(order.getId(), createdOrder.getId());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testCreateOrder_InvalidOrder_NullProduct() {
        Order order = new Order();
        order.setId(1L);
        order.setProduct(null);
        order.setQuantity(2);

        assertThrows(InvalidOrderException.class, () -> {
            orderService.createOrder(order);
        });

        verify(orderRepository, never()).save(any());
    }

    @Test
    public void testCreateOrder_InvalidOrder_NegativeQuantity() {
        Order order = new Order();
        order.setId(1L);
        order.setProduct("Product A");
        order.setQuantity(-1);

        assertThrows(InvalidOrderException.class, () -> {
            orderService.createOrder(order);
        });

        verify(orderRepository, never()).save(any());
    }

    @Test
    public void testCreateOrder_InvalidOrder_ZeroQuantity() {
        Order order = new Order();
        order.setId(1L);
        order.setProduct("Product A");
        order.setQuantity(0);

        assertThrows(InvalidOrderException.class, () -> {
            orderService.createOrder(order);
        });

        verify(orderRepository, never()).save(any());
    }

    @Test
    public void testCreateOrder_ValidOrder_ZeroId() {
        Order order = new Order();
        order.setId(0L);
        order.setProduct("Product B");
        order.setQuantity(5);

        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertNotNull(createdOrder);
        assertEquals(order.getId(), createdOrder.getId());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testCreateOrder_InvalidOrder_EmptyProduct() {
        Order order = new Order();
        order.setId(1L);
        order.setProduct("");
        order.setQuantity(2);

        assertThrows(InvalidOrderException.class, () -> {
            orderService.createOrder(order);
        });

        verify(orderRepository, never()).save(any());
    }

    @Test
    public void testCreateOrder_ExceptionHandling() {
        Order order = new Order();
        order.setId(1L);
        order.setProduct("Product C");
        order.setQuantity(3);

        when(orderRepository.save(order)).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> {
            orderService.createOrder(order);
        });

        verify(orderRepository, times(1)).save(order);
    }
}