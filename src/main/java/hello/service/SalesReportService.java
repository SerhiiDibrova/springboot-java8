package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class SalesReportService {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    private SalesReportRepository salesReportRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void populateSalesReport() {
        try {
            String createTableSql = "CREATE TEMPORARY TABLE #SalesReport (Order_Identifier VARCHAR(50), Customer_FullName VARCHAR(100), Sales_Status VARCHAR(50), Performance_Status VARCHAR(50), Discount_Status VARCHAR(50))";
            entityManager.createNativeQuery(createTableSql).executeUpdate();

            String sql = "INSERT INTO #SalesReport SELECT " +
                         "COALESCE(o.OrderId, 'N/A') AS Order_Identifier, " +
                         "COALESCE(c.FullName, 'Unknown') AS Customer_FullName, " +
                         "CASE WHEN s.Status IS NULL THEN 'Pending' ELSE s.Status END AS Sales_Status, " +
                         "CASE WHEN p.Performance IS NULL THEN 'Average' ELSE p.Performance END AS Performance_Status, " +
                         "CASE WHEN d.Discount IS NULL THEN 'No Discount' ELSE d.Discount END AS Discount_Status " +
                         "FROM Orders o " +
                         "LEFT JOIN Sales_data s ON o.OrderId = s.OrderId " +
                         "LEFT JOIN Customers c ON c.CustomerId = o.CustomerId " +
                         "LEFT JOIN Products p ON p.ProductId = s.ProductId " +
                         "LEFT JOIN Discounts d ON d.ProductId = p.ProductId " +
                         "LEFT JOIN #WarehouseReport wr ON wr.OrderId = o.OrderId " +
                         "WHERE wr.StockLevel = 0";

            entityManager.createNativeQuery(sql).executeUpdate();
        } catch (DataAccessException e) {
            logger.error("Data access error while populating SalesReport: {}", e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error while populating SalesReport: {}", e.getMessage(), e);
        }
    }

    public void generateSalesReport(SalesReportRequestDTO request) {
        try {
            entityManager.createNativeQuery("SET NOCOUNT ON").executeUpdate();
            entityManager.createNativeQuery("SET IMPLICIT_TRANSACTIONS OFF").executeUpdate();
            Integer hDoc = (Integer) entityManager.createNativeQuery("EXEC sp_xml_preparedocument @hDoc OUTPUT, :xmlData")
                    .setParameter("xmlData", request.getXmlData())
                    .getSingleResult();
            Integer default_manager_id = null;

            entityManager.createNativeQuery("CREATE TEMPORARY TABLE #TempItems (...)").executeUpdate();
            entityManager.createNativeQuery("CREATE TEMPORARY TABLE #WarehouseReport (...)").executeUpdate();
            entityManager.createNativeQuery("CREATE TEMPORARY TABLE #SalesReport (...)").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO #TempItems (...) SELECT ... FROM OPENXML(:hDoc, '/Filters/Filter', 2) WITH (...)")
                    .setParameter("hDoc", hDoc)
                    .executeUpdate();

            if (request.isAuditNeeded()) {
                Integer manager_id = (Integer) entityManager.createNativeQuery("SELECT GetDefaultManagerId(:managerId, :default_manager_id)")
                        .setParameter("managerId", request.getManagerId())
                        .setParameter("default_manager_id", default_manager_id)
                        .getSingleResult();
                if (manager_id != null) {
                    entityManager.createNativeQuery("INSERT INTO InsertAuditData(manager_id) VALUES (:manager_id)")
                            .setParameter("manager_id", manager_id)
                            .executeUpdate();
                }
            }
            entityManager.createNativeQuery("CALL InsertSalesReport()").executeUpdate();
            entityManager.createNativeQuery("CALL InsertWarehouseReport()").executeUpdate();
        } catch (Exception e) {
            logger.error("Error while generating SalesReport: {}", e.getMessage(), e);
        } finally {
            entityManager.createNativeQuery("EXEC sp_xml_removedocument :hDoc")
                    .setParameter("hDoc", hDoc)
                    .executeUpdate();
        }
    }
}