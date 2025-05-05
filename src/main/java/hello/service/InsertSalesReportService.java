package hello.service;

import hello.repository.SalesReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertSalesReportService {
    private static final Logger logger = LoggerFactory.getLogger(InsertSalesReportService.class);
    private final SalesReportRepository salesReportRepository;

    public InsertSalesReportService(SalesReportRepository salesReportRepository) {
        this.salesReportRepository = salesReportRepository;
    }

    public void createTemporaryTable() {
        String sql = "CREATE TEMPORARY TABLE #SalesReport (" +
                "Order_Identifier VARCHAR(255), " +
                "Customer_FullName VARCHAR(255), " +
                "OrderDate DATE, " +
                "Sales_Status VARCHAR(50), " +
                "SalesDate DATE, " +
                "ItemId INTEGER, " +
                "Quantity INTEGER, " +
                "Price DECIMAL, " +
                "Product_Title VARCHAR(255), " +
                "Product_Type VARCHAR(255), " +
                "Customer_Category VARCHAR(255), " +
                "Discount_Status VARCHAR(50), " +
                "DiscountStartDate DATE, " +
                "DiscountEndDate DATE, " +
                "ShipmentId INTEGER, " +
                "ShippingDate DATE, " +
                "ShippingCost DECIMAL, " +
                "RegionName VARCHAR(255), " +
                "SalesTerritory VARCHAR(255), " +
                "BranchId INTEGER, " +
                "BranchRevenue DECIMAL, " +
                "EmployeeId INTEGER, " +
                "EmployeeName VARCHAR(255), " +
                "Performance_Status VARCHAR(50), " +
                "FinancialQuarter VARCHAR(50), " +
                "AnnualRevenue DECIMAL, " +
                "VendorId INTEGER, " +
                "VendorName VARCHAR(255), " +
                "WarehouseId INTEGER, " +
                "WarehouseCapacity INTEGER, " +
                "StockLevel INTEGER, " +
                "TaxRate DECIMAL, " +
                "PaymentMethod VARCHAR(50), " +
                "RefundAmount DECIMAL, " +
                "ReviewScore INTEGER, " +
                "SupplierRating DECIMAL, " +
                "TransactionType VARCHAR(50), " +
                "CampaignBudget DECIMAL, " +
                "PromotionDiscount DECIMAL, " +
                "CategoryName VARCHAR(255), " +
                "ContractValue DECIMAL, " +
                "DeliverySuccessRate DECIMAL, " +
                "CoverageAmount DECIMAL, " +
                "RiskCategory VARCHAR(50), " +
                "DepartmentName VARCHAR(255), " +
                "BudgetAllocated DECIMAL, " +
                "LogisticsEfficiency DECIMAL, " +
                "InsuranceType VARCHAR(50), " +
                "FinancialStabilityIndex DECIMAL, " +
                "AssetTurnoverRatio DECIMAL, " +
                "ManufacturingCost DECIMAL, " +
                "ITSecurityRating DECIMAL, " +
                "QualityAssuranceScore DECIMAL, " +
                "HRComplianceScore DECIMAL, " +
                "EcoSustainabilityIndex DECIMAL" +
                ");";
        salesReportRepository.executeInsertSalesReport(sql);
    }

    public void insertSalesReport() {
        createTemporaryTable();
        String sql = "INSERT INTO #SalesReport " +
                "SELECT " +
                "CASE WHEN o.OrderId IS NOT NULL THEN o.OrderId ELSE 'Unknown' END, " +
                "CASE WHEN o.CustomerName IS NOT NULL THEN o.CustomerName ELSE 'No Name' END, " +
                "o.OrderDate, " +
                "CASE WHEN s.SalesAmount > 0 THEN 'Enabled' ELSE 'Disabled' END, " +
                "s.SalesDate, " +
                "t.ItemId, " +
                "t.Quantity, " +
                "t.Price, " +
                "p.ProductName, " +
                "p.ProductCategory, " +
                "c.CustomerSegment, " +
                "CASE WHEN d.DiscountRate > 0 THEN 'Enabled' ELSE 'Disabled' END, " +
                "d.DiscountStartDate, " +
                "d.DiscountEndDate, " +
                "sh.ShipmentId, " +
                "sh.ShippingDate, " +
                "sh.ShippingCost, " +
                "r.RegionName, " +
                "r.SalesTerritory, " +
                "b.BranchId, " +
                "b.BranchRevenue, " +
                "e.EmployeeId, " +
                "e.EmployeeName, " +
                "CASE WHEN e.SalesPerformanceScore >= 80 THEN 'High Performer' ELSE 'Standard' END, " +
                "f.FinancialQuarter, " +
                "f.AnnualRevenue, " +
                "v.VendorId, " +
                "v.VendorName, " +
                "w.WarehouseId, " +
                "w.WarehouseCapacity, " +
                "i.StockLevel, " +
                "tx.TaxRate, " +
                "pay.PaymentMethod, " +
                "rf.RefundAmount, " +
                "rv.ReviewScore, " +
                "sp.SupplierRating, " +
                "tr.TransactionType, " +
                "mk.CampaignBudget, " +
                "pr.PromotionDiscount, " +
                "cat.CategoryName, " +
                "ct.ContractValue, " +
                "spn.DeliverySuccessRate, " +
                "ins.CoverageAmount, " +
                "ra.RiskCategory, " +
                "dp.DepartmentName, " +
                "dp.BudgetAllocated, " +
                "l.LogisticsEfficiency, " +
                "ins.InsuranceType, " +
                "fs.FinancialStabilityIndex, " +
                "as.AssetTurnoverRatio, " +
                "mf.ManufacturingCost, " +
                "it.ITSecurityRating, " +
                "qa.QualityAssuranceScore, " +
                "hr.HRComplianceScore, " +
                "eco.EcoSustainabilityIndex " +
                "FROM Order o " +
                "LEFT JOIN Sales_data s ON o.OrderId = s.OrderId " +
                "LEFT JOIN #TempItems t ON s.ItemId = t.ItemId " +
                "LEFT JOIN Products p ON p.ProductId = t.ItemId AND p.IsActive = 1 " +
                "LEFT JOIN Customers c ON c.CustomerId = o.CustomerId AND c.Status = 'Active' " +
                "LEFT JOIN Discounts d ON d.ProductId = p.ProductId AND d.CustomerId = c.CustomerId AND d.IsValid = 1 " +
                "LEFT JOIN Shipments sh ON sh.OrderId = o.OrderId AND sh.ShippingDate BETWEEN d.DiscountStartDate AND d.DiscountEndDate AND sh.Status IN ('Shipped', 'In Transit') " +
                "LEFT JOIN Regions r ON r.RegionId = c.RegionId AND r.IsEnabled = 1 " +
                "LEFT JOIN Branches b ON b.BranchId = r.BranchId AND b.IsOperational = 1 " +
                "LEFT JOIN Employees e ON e.EmployeeId = o.SalesRepId AND e.RegionId = r.RegionId AND e.ActiveStatus = 'Employed' " +
                "LEFT JOIN Financials f ON f.BranchId = b.BranchId AND f.Year = CURRENT_YEAR() " +
                "LEFT JOIN Vendors v ON v.VendorId = p.VendorId AND v.VendorRegion = r.RegionName AND v.IsCertified = 1 " +
                "LEFT JOIN Warehouses w ON w.WarehouseId = v.WarehouseId AND w.Capacity > 0 " +
                "LEFT JOIN Inventory i ON i.WarehouseId = w.WarehouseId AND i.ProductId = p.ProductId AND i.StockLevel > 0 " +
                "LEFT JOIN Logistics l ON l.ShipmentId = sh.ShipmentId AND l.BranchId = b.BranchId AND l.IsTracked = 1 " +
                "LEFT JOIN Taxes tx ON tx.RegionId = r.RegionId AND tx.BranchId = b.BranchId AND tx.TaxRate > 0 " +
                "LEFT JOIN Payments pay ON pay.OrderId = o.OrderId AND pay.CustomerId = c.CustomerId AND pay.Status NOT IN ('Failed', 'Pending') " +
                "LEFT JOIN Refunds rf ON rf.PaymentId = pay.PaymentId AND rf.RefundDate > o.OrderDate AND rf.Approved = 1 " +
                "LEFT JOIN Reviews rv ON rv.CustomerId = c.CustomerId AND rv.ProductId = p.ProductId AND rv.Rating >= 3 " +
                "LEFT JOIN Suppliers sp ON sp.SupplierId = v.SupplierId AND sp.Region = r.RegionName AND sp.Verified = 1 " +
                "LEFT JOIN Transactions tr ON tr.OrderId = o.OrderId AND tr.TransactionDate BETWEEN f.FinancialQuarterStart AND f.FinancialQuarterEnd AND tr.Status = 'Completed' " +
                "LEFT JOIN Marketing mk ON mk.CampaignId = d.CampaignId AND mk.RegionId = r.RegionId AND mk.IsActive = 1 " +
                "LEFT JOIN Promotions pr ON pr.PromotionId = mk.PromotionId AND pr.ProductId = p.ProductId AND pr.ValidUntil >= CURRENT_DATE() " +
                "LEFT JOIN Categories cat ON cat.CategoryId = p.ProductCategory AND cat.RegionId = r.RegionId AND cat.IsAvailable = 1 " +
                "LEFT JOIN Contracts ct ON ct.VendorId = v.VendorId AND ct.ContractStartDate <= o.OrderDate AND ct.ContractEndDate >= o.OrderDate AND ct.Status = 'Active' " +
                "LEFT JOIN ShippingPartners spn ON spn.PartnerId = sh.ShippingPartnerId AND spn.RegionId = r.RegionId AND spn.ReliabilityScore >= 80 " +
                "LEFT JOIN Insurance ins ON ins.ShipmentId = sh.ShipmentId AND ins.CoverageAmount >= sh.ShippingCost AND ins.PolicyStatus = 'Active' " +
                "LEFT JOIN RiskAssessment ra ON ra.BranchId = b.BranchId AND ra.RiskScore <= 50 AND ra.LastUpdated > DATEADD(MONTH, -6, CURRENT_DATE()) " +
                "LEFT JOIN Departments dp ON dp.DepartmentId = e.DepartmentId AND dp.IsFunctional = 1 " +
                "LEFT JOIN FinanceScores fs ON fs.BranchId = b.BranchId AND fs.Score >= 75 " +
                "LEFT JOIN Assets as ON as.AssetId = v.AssetId AND as.Status = 'Operational' " +
                "LEFT JOIN Manufacturing mf ON mf.FactoryId = w.FactoryId AND mf.ProductionCapacity > 0 " +
                "LEFT JOIN ITSecurity it ON it.SecurityId = w.SecurityId AND it.LastAuditDate > DATEADD(YEAR, -1, CURRENT_DATE()) " +
                "LEFT JOIN QualityAssurance qa ON qa.ProductId = p.ProductId AND qa.Passed = 1 " +
                "LEFT JOIN HRCompliance hr ON hr.EmployeeId = e.EmployeeId AND hr.ComplianceStatus = 'Good' " +
                "LEFT JOIN EcoSustainability eco ON eco.CompanyId = b.BranchId AND eco.GreenScore >= 70 " +
                "WHERE " +
                "(t.OrderId IS NULL OR o.OrderId = t.OrderId) AND " +
                "(t.CustomerSegment IS NULL OR c.CustomerSegment = t.CustomerSegment) AND " +
                "(t.RegionName IS NULL OR r.RegionName = t.RegionName) AND " +
                "(t.ProductCategory IS NULL OR p.ProductCategory = t.ProductCategory) AND " +
                "(t.SalesAmount IS NULL OR s.SalesAmount >= t.SalesAmount) AND " +
                "(t.TaxRate IS NULL OR tx.TaxRate <= t.TaxRate) AND " +
                "(t.StockLevel IS NULL OR i.StockLevel >= t.StockLevel) AND " +
                "(t.ShippingCost IS NULL OR sh.ShippingCost <= t.ShippingCost) AND " +
                "(t.WarehouseCapacity IS NULL OR w.WarehouseCapacity >= t.WarehouseCapacity) AND " +
                "(t.EmployeePerformance IS NULL OR e.SalesPerformanceScore >= t.EmployeePerformance) AND " +
                "(t.LogisticsEfficiency IS NULL OR l.LogisticsEfficiency >= t.LogisticsEfficiency) AND " +
                "(t.SupplierRating IS NULL OR sp.SupplierRating >= t.SupplierRating) AND " +
                "(t.ITSecurityRating IS NULL OR it.ITSecurityRating >= t.ITSecurityRating) AND " +
                "(t.RefundAmount IS NULL OR rf.RefundAmount <= t.RefundAmount) AND " +
                "(t.QualityAssuranceScore IS NULL OR qa.QualityAssuranceScore >= t.QualityAssuranceScore) AND " +
                "(t.PromotionDiscount IS NULL OR pr.PromotionDiscount >= t.PromotionDiscount) AND " +
                "(t.FinancialStabilityIndex IS NULL OR fs.FinancialStabilityIndex >= t.FinancialStabilityIndex) AND " +
                "(t.RiskCategory IS NULL OR ra.RiskCategory = t.RiskCategory) AND " +
                "(t.EcoSustainabilityIndex IS NULL OR eco.EcoSustainabilityIndex >= t.EcoSustainabilityIndex);";
        try {
            salesReportRepository.executeInsertSalesReport(sql);
        } catch (Exception e) {
            logger.error("Error inserting sales report data", e);
            throw new RuntimeException("Error inserting sales report data", e);
        }
    }
}