package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    Logger logger = LoggerFactory.getLogger(SalesReportRepository.class);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO #SalesReport (Order_Identifier, Customer_FullName, OrderDate, Sales_Status, SalesDate, ItemId, Quantity, Price, Product_Title, Product_Type, Customer_Category, Discount_Status, DiscountStartDate, DiscountEndDate, ShipmentId, ShippingDate, ShippingCost, RegionName, SalesTerritory, BranchId, BranchRevenue, EmployeeId, EmployeeName, Performance_Status, FinancialQuarter, AnnualRevenue, VendorId, VendorName, WarehouseId, WarehouseCapacity, StockLevel, TaxRate, PaymentMethod, RefundAmount, ReviewScore, SupplierRating, TransactionType, CampaignBudget, PromotionDiscount, CategoryName, ContractValue, DeliverySuccessRate, CoverageAmount, RiskCategory, DepartmentName, BudgetAllocated, FinancialStabilityIndex, AssetTurnoverRatio, ManufacturingCost, ITSecurityRating, QualityAssuranceScore, HRComplianceScore, EcoSustainabilityIndex) " +
           "SELECT o.Order_Identifier, c.FullName, o.OrderDate, o.Sales_Status, o.SalesDate, i.ItemId, i.Quantity, i.Price, p.Title, p.Type, c.Category, d.Status, d.StartDate, d.EndDate, s.ShipmentId, s.ShippingDate, s.Cost, r.Name, t.Territory, b.Id, b.Revenue, e.Id, e.Name, e.Performance_Status, f.Quarter, f.AnnualRevenue, v.Id, v.Name, w.Id, w.Capacity, w.StockLevel, t.TaxRate, p.Method, r.Amount, r.Score, s.Rating, t.Type, c.Budget, p.Discount, cat.Name, con.Value, d.SuccessRate, c.Amount, r.Category, d.Name, b.Allocated, f.StabilityIndex, a.Ratio, m.Cost, it.Rating, qa.Score, h.Score, e.Index " +
           "FROM Orders o " +
           "LEFT JOIN Customers c ON o.CustomerId = c.Id " +
           "LEFT JOIN Items i ON o.ItemId = i.Id " +
           "LEFT JOIN Products p ON i.ProductId = p.Id " +
           "LEFT JOIN Discounts d ON o.DiscountId = d.Id " +
           "LEFT JOIN Shipments s ON o.ShipmentId = s.Id " +
           "LEFT JOIN Regions r ON o.RegionId = r.Id " +
           "LEFT JOIN Territories t ON o.TerritoryId = t.Id " +
           "LEFT JOIN Branches b ON o.BranchId = b.Id " +
           "LEFT JOIN Employees e ON o.EmployeeId = e.Id " +
           "LEFT JOIN Financials f ON o.FinancialId = f.Id " +
           "LEFT JOIN Vendors v ON o.VendorId = v.Id " +
           "LEFT JOIN Warehouses w ON o.WarehouseId = w.Id " +
           "LEFT JOIN Taxes t ON o.TaxId = t.Id " +
           "LEFT JOIN Refunds r ON o.RefundId = r.Id " +
           "LEFT JOIN Suppliers s ON o.SupplierId = s.Id " +
           "LEFT JOIN Contracts con ON o.ContractId = con.Id " +
           "LEFT JOIN Campaigns c ON o.CampaignId = c.Id " +
           "LEFT JOIN Categories cat ON p.CategoryId = cat.Id " +
           "LEFT JOIN Departments d ON o.DepartmentId = d.Id " +
           "LEFT JOIN Budgets b ON o.BudgetId = b.Id " +
           "LEFT JOIN Assets a ON o.AssetId = a.Id " +
           "LEFT JOIN Manufacturing m ON o.ManufacturingId = m.Id " +
           "LEFT JOIN ITSecurity it ON o.ITSecurityId = it.Id " +
           "LEFT JOIN QualityAssurance qa ON o.QualityAssuranceId = qa.Id " +
           "LEFT JOIN HRCompliance h ON o.HRComplianceId = h.Id " +
           "LEFT JOIN EcoSustainability eco ON o.EcoSustainabilityId = eco.Id " +
           "WHERE o.OrderDate IS NOT NULL AND o.Sales_Status = 'Completed'", nativeQuery = true)
    void insertSalesReportData();
}