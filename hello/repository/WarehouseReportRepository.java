package hello.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReportRepository {

    void insertWarehouseReport(WarehouseReport report);

    void createTemporaryWarehouseReportTable();

    void createTemporaryItemsTable();
}