package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "orderId", nullable = false)
    private Long orderId;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @NotNull
    @Column(name = "quantity", nullable = false, columnDefinition = "int default 0")
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "price", nullable = false, columnDefinition = "decimal(18,2) default 0.00")
    private Double price;

    @Column(name = "CustomerSegment")
    private String customerSegment;

    @Column(name = "RegionName")
    private String regionName;

    @Column(name = "ProductCategory")
    private String productCategory;

    @Column(name = "SalesAmount")
    private Double salesAmount;

    @Column(name = "TaxRate")
    private Double taxRate;

    @Column(name = "StockLevel")
    private Integer stockLevel;

    @Column(name = "ShippingCost")
    private Double shippingCost;

    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;

    @Column(name = "EmployeePerformance")
    private Integer employeePerformance;

    @Column(name = "LogisticsEfficiency")
    private Double logisticsEfficiency;

    @Column(name = "SupplierRating")
    private Double supplierRating;

    @Column(name = "ITSecurityRating")
    private Double itSecurityRating;

    @Column(name = "RefundAmount")
    private Double refundAmount;

    @Column(name = "QualityAssuranceScore")
    private Double qualityAssuranceScore;

    @Column(name = "PromotionDiscount")
    private Double promotionDiscount;

    @Column(name = "FinancialStabilityIndex")
    private Double financialStabilityIndex;

    @Column(name = "RiskCategory")
    private String riskCategory;

    @Column(name = "EcoSustainabilityIndex")
    private Double ecoSustainabilityIndex;

    // Getters and Setters
}

package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "#WarehouseReport")
public class WarehouseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "warehouseId", nullable = false)
    private Long warehouseId;

    @NotNull
    @Column(name = "warehouseName", nullable = false)
    private String warehouseName;

    @NotNull
    @Column(name = "warehouseCapacity", nullable = false)
    private Integer warehouseCapacity;

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "regionName")
    private String regionName;

    @Column(name = "branchName")
    private String branchName;

    @Column(name = "vendorName")
    private String vendorName;

    @Column(name = "productCategory")
    private String productCategory;

    @Column(name = "stockLevel")
    private Integer stockLevel;

    @Column(name = "logisticsEfficiency")
    private Double logisticsEfficiency;

    // Getters and Setters
}