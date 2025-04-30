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
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Integer> {
    @Override
    List<WarehouseReport> findAll();

    @Query("SELECT wr FROM WarehouseReport wr WHERE wr.someField = :value")
    List<WarehouseReport> findBySomeField(@Param("value") String value);
}