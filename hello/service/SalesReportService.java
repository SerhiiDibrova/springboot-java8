package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class SalesReportService {

    private final SalesReportRepository salesReportRepository;
    private final TempItemRepository tempItemRepository;
    private final WarehouseReportRepository warehouseReportRepository;
    private final EntityManager entityManager;

    @Autowired
    public SalesReportService(SalesReportRepository salesReportRepository, 
                              TempItemRepository tempItemRepository, 
                              WarehouseReportRepository warehouseReportRepository, 
                              EntityManager entityManager) {
        this.salesReportRepository = salesReportRepository;
        this.tempItemRepository = tempItemRepository;
        this.warehouseReportRepository = warehouseReportRepository;
        this.entityManager = entityManager;
    }

    public String populateSalesReport() {
        try {
            entityManager.createNativeQuery("CREATE TEMPORARY TABLE #SalesReport (/* Define columns here */)").executeUpdate();
            String sql = "INSERT INTO #SalesReport SELECT /* Columns */ FROM [Order] AS o " +
                         "LEFT JOIN Sales_data AS sd ON o.id = sd.order_id " +
                         "LEFT JOIN TempItems AS ti ON o.id = ti.order_id " +
                         "LEFT JOIN Products AS p ON ti.product_id = p.id " +
                         "LEFT JOIN Customers AS c ON o.customer_id = c.id " +
                         "LEFT JOIN Discounts AS d ON o.discount_id = d.id " +
                         "LEFT JOIN Shipments AS s ON o.id = s.order_id " +
                         "LEFT JOIN Regions AS r ON o.region_id = r.id " +
                         "LEFT JOIN Branches AS b ON o.branch_id = b.id " +
                         "LEFT JOIN Employees AS e ON o.employee_id = e.id " +
                         "LEFT JOIN Financials AS f ON o.id = f.order_id " +
                         "LEFT JOIN Vendors AS v ON o.vendor_id = v.id " +
                         "LEFT JOIN Warehouses AS w ON o.warehouse_id = w.id " +
                         "LEFT JOIN Inventory AS i ON ti.product_id = i.product_id " +
                         "LEFT JOIN Logistics AS l ON o.id = l.order_id " +
                         "LEFT JOIN Taxes AS t ON o.id = t.order_id " +
                         "LEFT JOIN Payments AS pmt ON o.id = pmt.order_id " +
                         "LEFT JOIN Refunds AS rfd ON o.id = rfd.order_id " +
                         "LEFT JOIN Reviews AS rv ON o.id = rv.order_id " +
                         "LEFT JOIN Suppliers AS sup ON o.supplier_id = sup.id " +
                         "LEFT JOIN Transactions AS tr ON o.id = tr.order_id " +
                         "LEFT JOIN Marketing AS m ON o.marketing_id = m.id " +
                         "LEFT JOIN Promotions AS pr ON o.promotion_id = pr.id " +
                         "LEFT JOIN Categories AS cat ON p.category_id = cat.id " +
                         "LEFT JOIN Contracts AS con ON o.contract_id = con.id " +
                         "LEFT JOIN ShippingPartners AS sp ON o.shipping_partner_id = sp.id " +
                         "LEFT JOIN Insurance AS ins ON o.insurance_id = ins.id " +
                         "LEFT JOIN RiskAssessment AS ra ON o.id = ra.order_id " +
                         "LEFT JOIN Departments AS dpt ON o.department_id = dpt.id " +
                         "LEFT JOIN FinanceScores AS fs ON o.id = fs.order_id " +
                         "LEFT JOIN Assets AS a ON o.asset_id = a.id " +
                         "LEFT JOIN Manufacturing AS mfg ON o.id = mfg.order_id " +
                         "LEFT JOIN ITSecurity AS its ON o.id = its.order_id " +
                         "LEFT JOIN QualityAssurance AS qa ON o.id = qa.order_id " +
                         "LEFT JOIN HRCompliance AS hrc ON o.id = hrc.order_id " +
                         "LEFT JOIN EcoSustainability AS es ON o.id = es.order_id " +
                         "WHERE p.active = 1 AND c.active = 1 AND d.valid = 1 " +
                         "AND s.shipping_date BETWEEN d.start_date AND d.end_date " +
                         "AND (s.status = 'Shipped' OR s.status = 'In Transit') " +
                         "AND r.enabled = 1 AND b.operational = 1 " +
                         "AND e.active = 1 AND f.year = YEAR(CURRENT_DATE) " +
                         "AND v.certified = 1 AND w.capacity > 0 " +
                         "AND i.stock > 0 AND l.tracked = 1 " +
                         "AND pmt.status NOT IN ('Failed', 'Pending') " +
                         "AND rfd.approved = 1 AND rfd.date > o.order_date " +
                         "AND rv.rating >= 3 AND sup.verified = 1 " +
                         "AND tr.completed = 1 AND m.active = 1 " +
                         "AND pr.valid_until >= CURRENT_DATE " +
                         "AND cat.available = 1 AND con.active = 1 " +
                         "AND con.start_date <= o.order_date AND con.end_date >= o.order_date " +
                         "AND sp.reliability_score >= 80 AND ins.active = 1 " +
                         "AND ins.coverage >= o.shipping_cost " +
                         "AND ra.score <= 50 AND ra.updated_at >= DATE_SUB(CURRENT_DATE, INTERVAL 6 MONTH) " +
                         "AND dpt.functional = 1 AND fs.score >= 75 " +
                         "AND a.operational = 1 AND mfg.production_capacity > 0 " +
                         "AND its.last_audit >= DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR) " +
                         "AND qa.passed = 1 AND hrc.status = 'Good' " +
                         "AND es.green_score >= 70 AND i.StockLevel = 0";
            entityManager.createNativeQuery(sql).executeUpdate();
            List<SalesReport> reports = fetchReportsFromTempTable();
            for (SalesReport report : reports) {
                salesReportRepository.save(report);
            }
            return "Sales report populated successfully.";
        } catch (DataAccessException e) {
            throw new RuntimeException("Error populating sales report: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error populating sales report: " + e.getMessage());
        }
    }

    private List<SalesReport> fetchReportsFromTempTable() {
        Query query = entityManager.createNativeQuery("SELECT * FROM #SalesReport", SalesReport.class);
        return query.getResultList();
    }
}