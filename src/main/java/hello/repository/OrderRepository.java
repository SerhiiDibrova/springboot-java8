package hello.repository;

import hello.entity.OrderDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderDB, UUID> {
    List<OrderDB> findAllByOrderByCreatedAtDesc();
    OrderDB save(OrderDB order);
}