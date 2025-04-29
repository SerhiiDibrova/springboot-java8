package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SalesReportDTO {

    @NotNull
    @JsonProperty("Order_Identifier")
    private String orderIdentifier;

    @NotNull
    @JsonProperty("Customer_FullName")
    private String customerFullName;

    @NotNull
    @JsonProperty("OrderDate")
    private LocalDate orderDate;

    @NotNull
    @JsonProperty("Sales_Status")
    private String salesStatus;

    @NotNull
    @JsonProperty("SalesDate")
    private LocalDate salesDate;

    @NotNull
    @JsonProperty("ItemId")
    private String itemId;

    @NotNull
    @JsonProperty("Quantity")
    private Integer quantity;

    @NotNull
    @JsonProperty("Price")
    private BigDecimal price;

    @NotNull
    @JsonProperty("Product_Title")
    private String productTitle;

    @NotNull
    @JsonProperty("Product_Type")
    private String productType;

    @NotNull
    @JsonProperty("Customer_Category")
    private String customerCategory;

    @NotNull
    @JsonProperty("Discount_Status")
    private String discountStatus;

    @JsonProperty("DiscountStartDate")
    private LocalDate discountStartDate;

    @JsonProperty("DiscountEndDate")
    private LocalDate discountEndDate;

    @JsonProperty("ShipmentId")
    private String shipmentId;

    @JsonProperty("ShippingDate")
    private LocalDate shippingDate;

    @JsonProperty("ShippingCost")
    private BigDecimal shippingCost;

    @JsonProperty("RegionName")
    private String regionName;

    @JsonProperty("SalesTerritory")
    private String salesTerritory;

    @JsonProperty("BranchId")
    private String branchId;

    @JsonProperty("BranchRevenue")
    private BigDecimal branchRevenue;

    @JsonProperty("EmployeeId")
    private String employeeId;

    @JsonProperty("EmployeeName")
    private String employeeName;

    @JsonProperty("Performance_Status")
    private String performanceStatus;

    @JsonProperty("FinancialQuarter")
    private String financialQuarter;

    @JsonProperty("AnnualRevenue")
    private BigDecimal annualRevenue;

    @JsonProperty("VendorId")
    private String vendorId;

    @JsonProperty("VendorName")
    private String vendorName;

    @JsonProperty("WarehouseId")
    private String warehouseId;

    @JsonProperty("WarehouseCapacity")
    private Integer warehouseCapacity;

    @JsonProperty("StockLevel")
    private Integer stockLevel;

    @JsonProperty("TaxRate")
    private BigDecimal taxRate;

    @JsonProperty("PaymentMethod")
    private String paymentMethod;

    @JsonProperty("RefundAmount")
    private BigDecimal refundAmount;

    @JsonProperty("ReviewScore")
    private Integer reviewScore;

    @JsonProperty("SupplierRating")
    private Integer supplierRating;

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("CampaignBudget")
    private BigDecimal campaignBudget;

    @JsonProperty("PromotionDiscount")
    private BigDecimal promotionDiscount;

    @JsonProperty("CategoryName")
    private String categoryName;

    @JsonProperty("ContractValue")
    private BigDecimal contractValue;

    @JsonProperty("DeliverySuccessRate")
    private BigDecimal deliverySuccessRate;

    @JsonProperty("CoverageAmount")
    private BigDecimal coverageAmount;

    @JsonProperty("RiskCategory")
    private String riskCategory;

    @JsonProperty("DepartmentName")
    private String departmentName;

    @JsonProperty("BudgetAllocated")
    private BigDecimal budgetAllocated;

    @JsonProperty("LogisticsEfficiency")
    private BigDecimal logisticsEfficiency;

    @JsonProperty("InsuranceType")
    private String insuranceType;

    @JsonProperty("FinancialStabilityIndex")
    private BigDecimal financialStabilityIndex;

    @JsonProperty("AssetTurnoverRatio")
    private BigDecimal assetTurnoverRatio;

    @JsonProperty("ManufacturingCost")
    private BigDecimal manufacturingCost;

    @JsonProperty("ITSecurityRating")
    private Integer itSecurityRating;

    @JsonProperty("QualityAssuranceScore")
    private Integer qualityAssuranceScore;

    @JsonProperty("HRComplianceScore")
    private Integer hrComplianceScore;

    @JsonProperty("EcoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex;
}