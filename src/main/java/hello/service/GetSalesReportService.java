package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class GetSalesReportService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private AuditDataService auditDataService;

    @Autowired
    private DataSource dataSource;

    public void generateSalesReport(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        int hDoc = 0;
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("SET NOCOUNT ON");
            statement.execute("SET IMPLICIT_TRANSACTIONS OFF");

            hDoc = prepareXmlDocument(xmlData);
            Integer defaultManagerId = getDefaultManagerId(managerId);

            statement.execute("CREATE TABLE #TempItems (Column1 INT, Column2 VARCHAR(255))");
            statement.execute("CREATE TABLE #WarehouseReport (Column1 INT, Column2 VARCHAR(255))");
            statement.execute("CREATE TABLE #SalesReport (Column1 INT, Column2 VARCHAR(255))");

            insertTempItems(statement, hDoc);

            if (isAuditNeeded) {
                if (managerId != null) {
                    auditDataService.insertAuditData(managerId);
                }
            }

            insertSalesReport();
            insertWarehouseReport();

            connection.commit();
        } catch (SQLException e) {
            // Handle errors
        } finally {
            removeXmlDocument(hDoc);
        }
    }

    private int prepareXmlDocument(String xmlData) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("EXEC sp_xml_preparedocument ?, ?")) {
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, xmlData);
            preparedStatement.execute();
            return 0; // Replace with actual handle
        }
    }

    private void removeXmlDocument(int hDoc) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("EXEC sp_xml_removedocument ?")) {
            preparedStatement.setInt(1, hDoc);
            preparedStatement.execute();
        } catch (SQLException e) {
            // Handle errors
        }
    }

    private void insertTempItems(Statement statement, int hDoc) throws SQLException {
        statement.execute("INSERT INTO #TempItems SELECT * FROM OPENXML(" + hDoc + ", '/Filters/Filter', 2) WITH (Column1 INT 'Column1', Column2 VARCHAR(255) 'Column2')");
    }

    private void insertSalesReport() {
        // Implementation for inserting sales report
    }

    private void insertWarehouseReport() {
        // Implementation for inserting warehouse report
    }

    private Integer getDefaultManagerId(Integer managerId) {
        // Implementation for retrieving default manager ID
        return null; // Replace with actual implementation
    }
}