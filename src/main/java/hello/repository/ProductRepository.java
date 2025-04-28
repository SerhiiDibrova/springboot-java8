// src/main/java/hello/repository/ProductRepository.java
package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.entity.ProductDB;

@Repository
public interface ProductRepository extends JpaRepository<ProductDB, Long> {

}
