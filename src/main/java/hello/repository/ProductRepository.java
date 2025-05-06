package hello.repository;

import hello.entity.ProductDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductDB, UUID> {
    List<ProductDB> findAllByOrderByName();
    Optional<ProductDB> findById(UUID id);
    void deleteById(UUID id);
    List<ProductDB> findByCategory(String category);
}