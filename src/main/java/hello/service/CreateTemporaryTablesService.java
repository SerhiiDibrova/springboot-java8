

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CreateTemporaryTablesService {

    private final CreateTable1Service createTable1Service;
    private final CreateTable2Service createTable2Service;
    private final CreateTable3Service createTable3Service;

    @Autowired
    public CreateTemporaryTablesService(CreateTable1Service createTable1Service, CreateTable2Service createTable2Service, CreateTable3Service createTable3Service) {
        this.createTable1Service = createTable1Service;
        this.createTable2Service = createTable2Service;
        this.createTable3Service = createTable3Service;
    }

    public void createTemporaryTables() {
        try {
            createTable1Service.createTable();
            createTable2Service.createTable();
            createTable3Service.createTable();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create temporary tables", e);
        }
    }
}