package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.ProductDB;
import java.util.UUID;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDB, UUID> {
    List<ProductDB> findAllByOrderByName();
}