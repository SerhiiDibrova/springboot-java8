package hello.repository;

import hello.model.WarehouseData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseDataRepository extends JpaRepository<WarehouseData, Long> {
}