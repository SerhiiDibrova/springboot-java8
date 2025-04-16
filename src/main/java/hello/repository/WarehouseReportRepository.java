

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import hello.entity.WarehouseReportEntity;
import java.util.List;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReportEntity, Long> {

    @Query("SELECT wr FROM WarehouseReportEntity wr WHERE wr.warehouseId = :warehouseId AND wr.reportDate = :reportDate")
    List<WarehouseReportEntity> getWarehouseReportData(@Param("warehouseId") Long warehouseId, @Param("reportDate") Date reportDate);

}