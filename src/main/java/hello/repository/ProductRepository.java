package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.ProductDB;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDB, Long> {
    Optional<ProductDB> findById(UUID productId);
    List<ProductDB> findAllByOrderByName();
}