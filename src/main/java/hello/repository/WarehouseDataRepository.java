package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import hello.model.WarehouseData;
import hello.model.TempItems;

import java.util.List;

public interface WarehouseDataRepository extends JpaRepository<WarehouseData, Long> {
    
    @Query("SELECT wd FROM WarehouseData wd WHERE wd.item IN (SELECT ti.item FROM TempItems ti WHERE ti IN :tempItems)")
    List<WarehouseData> findByTempItems(@Param("tempItems") List<TempItems> tempItems);
}