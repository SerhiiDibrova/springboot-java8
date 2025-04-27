package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.model.WarehouseData;
import hello.dto.TempItemsDTO;

import java.util.List;

public interface WarehouseDataRepository extends JpaRepository<WarehouseData, Long> {
    
    @Query("SELECT wd FROM WarehouseData wd JOIN wd.tempItems ti WHERE ti IN :tempItems")
    List<WarehouseData> findWarehouseDataByTempItems(@Param("tempItems") List<TempItemsDTO> tempItems);
}