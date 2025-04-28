package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.ProductDB;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductDB, UUID> {
    Optional<ProductDB> findById(UUID id);
    List<ProductDB> findAllByOrderByNameAsc();
}