package hello.repository;

import hello.entity.TempItem;
import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    @Query("SELECT t FROM TempItem t WHERE t.customerSegment = :customerSegment")
    List<TempItem> findByCustomerSegment(@Param("customerSegment") String customerSegment);
}

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
    void save(WarehouseReport warehouseReport);
    List<WarehouseReport> findAll();
}