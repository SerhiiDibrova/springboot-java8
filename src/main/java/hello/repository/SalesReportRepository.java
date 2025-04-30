package hello.repository;

import hello.entity.SalesReport;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    Optional<SalesReport> findById(Long id);
    void deleteById(Long id);
    List<SalesReport> findAll();
    
    @Query("SELECT sr FROM SalesReport sr JOIN Orders o ON sr.orderId = o.id JOIN Inventory i ON sr.inventoryId = i.id JOIN Products p ON sr.productId = p.id JOIN Customers c ON sr.customerId = c.id JOIN Discounts d ON sr.discountId = d.id JOIN Shipments s ON sr.shipmentId = s.id JOIN Regions r ON sr.regionId = r.id JOIN Branches b ON sr.branchId = b.id JOIN Employees e ON sr.employeeId = e.id JOIN Financials f ON sr.financialId = f.id JOIN Vendors v ON sr.vendorId = v.id JOIN Taxes t ON sr.taxId = t.id JOIN Payments pmt ON sr.paymentId = pmt.id JOIN Refunds rf ON sr.refundId = rf.id JOIN Reviews rv ON sr.reviewId = rv.id JOIN Suppliers sp ON sr.supplierId = sp.id JOIN Transactions tr ON sr.transactionId = tr.id JOIN Marketing m ON sr.marketingId = m.id JOIN Promotions pr ON sr.promotionId = pr.id JOIN Categories cat ON sr.categoryId = cat.id JOIN Contracts ct ON sr.contractId = ct.id JOIN ShippingPartners spn ON sr.shippingPartnerId = spn.id JOIN Insurance ins ON sr.insuranceId = ins.id JOIN RiskAssessment ra ON sr.riskAssessmentId = ra.id JOIN Departments dpt ON sr.departmentId = dpt.id JOIN FinanceScores fs ON sr.financeScoreId = fs.id JOIN Assets a ON sr.assetId = a.id JOIN Manufacturing mf ON sr.manufacturingId = mf.id JOIN ITSecurity its ON sr.itSecurityId = its.id JOIN QualityAssurance qa ON sr.qualityAssuranceId = qa.id JOIN HRCompliance hrc ON sr.hrComplianceId = hrc.id JOIN EcoSustainability es ON sr.ecoSustainabilityId = es.id")
    List<SalesReport> customQueryMethod(String filter);
    
    List<SalesReport> findBySomeField(String someField, Pageable pageable);
}