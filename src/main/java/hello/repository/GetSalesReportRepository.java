package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GetSalesReportRepositoryImpl implements GetSalesReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public GetSalesReportRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void insertTempItems(Integer orderId, String xmlData) {
        String sql = "INSERT INTO #TempItems (OrderId, XmlData) VALUES (?, ?)";
        jdbcTemplate.update(sql, orderId, xmlData);
        parseAndInsertXmlData(xmlData);
    }

    @Override
    @Transactional
    public void insertWarehouseReport() {
        String sql = "INSERT INTO #WarehouseReport SELECT * FROM #TempItems";
        jdbcTemplate.update(sql);
    }

    @Override
    @Transactional
    public void insertSalesReport() {
        String sql = "INSERT INTO #SalesReport SELECT * FROM #WarehouseReport";
        jdbcTemplate.update(sql);
    }

    @Override
    public Integer getDefaultManagerId(Integer managerId) {
        String sql = "SELECT DefaultManagerId FROM Managers WHERE ManagerId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{managerId}, Integer.class);
    }

    @Override
    @Transactional
    public void insertAuditData(Integer managerId) {
        String sql = "INSERT INTO Audit (ManagerId, Action) VALUES (?, 'Insert')";
        jdbcTemplate.update(sql, managerId);
    }

    private void parseAndInsertXmlData(String xmlData) {
        // XML parsing logic and insertion into the database
    }
}