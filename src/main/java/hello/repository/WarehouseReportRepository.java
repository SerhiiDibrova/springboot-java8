

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Transactional;
import org.springframework.stereotype.Repository;

import hello.entity.WarehouseReport;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {

    @Modifying
    @Transactional
    @Query(value = "CREATE TABLE IF NOT EXISTS warehouse_report (id BIGINT PRIMARY KEY, name VARCHAR(255))", nativeQuery = true)
    void createWarehouseReportTable();

}