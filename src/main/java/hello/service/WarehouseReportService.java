package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class WarehouseReportService {

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private TempItemsRepository tempItemsRepository;

    @Autowired
    private DataSource dataSource;

    public void populateWarehouseReport() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE #WarehouseReport (Column1 DataType, Column2 DataType, ...);");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO #WarehouseReport (Column1, Column2, ...) SELECT Column1, Column2, ... FROM #TempItems WHERE <filtering_conditions>;");
            preparedStatement.executeUpdate();
            statement.execute("DROP TABLE #WarehouseReport;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}