package hello.repository;

import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {

    List<WarehouseReport> findByOrderId(Long orderId);

    List<WarehouseReport> findByRegionName(String regionName);

    List<WarehouseReport> findByProductCategory(String productCategory);

    List<WarehouseReport> findAllByWarehouseId(Long warehouseId);

    @Query("SELECT wr FROM WarehouseReport wr WHERE wr.stockLevel >= :stockLevel")
    List<WarehouseReport> findByStockLevelGreaterThanEqual(@Param("stockLevel") Integer stockLevel);

    @Query("SELECT wr FROM WarehouseReport wr WHERE wr.logisticsEfficiency >= :efficiency")
    List<WarehouseReport> findByLogisticsEfficiencyGreaterThanEqual(@Param("efficiency") Double efficiency);

    @Query("SELECT wr FROM WarehouseReport wr WHERE (:orderId IS NULL OR wr.orderId = :orderId) " +
           "AND (:regionName IS NULL OR wr.regionName = :regionName) " +
           "AND (:productCategory IS NULL OR wr.productCategory = :productCategory) " +
           "AND (:warehouseId IS NULL OR wr.warehouseId = :warehouseId) " +
           "AND (:stockLevel IS NULL OR wr.stockLevel >= :stockLevel) " +
           "AND (:efficiency IS NULL OR wr.logisticsEfficiency >= :efficiency)")
    List<WarehouseReport> findByCriteria(@Param("orderId") Long orderId,
                                          @Param("regionName") String regionName,
                                          @Param("productCategory") String productCategory,
                                          @Param("warehouseId") Long warehouseId,
                                          @Param("stockLevel") Integer stockLevel,
                                          @Param("efficiency") Double efficiency);
}