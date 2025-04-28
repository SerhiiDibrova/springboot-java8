package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import hello.entity.ProductDB;

@Repository
public interface ProductRepository extends JpaRepository<ProductDB, Long> {
    List<ProductDB> findAllByOrderByName();
}