package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.WarehouseData;

public interface WarehouseDataRepository extends JpaRepository<WarehouseData, Long> {
}