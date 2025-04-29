package hello.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "CustomerSegment")
    private String customerSegment;

    @Column(name = "RegionName")
    private String regionName;

    @Column(name = "ProductCategory")
    private String productCategory;

    @Column(name = "SalesAmount")
    private BigDecimal salesAmount;

    @Column(name = "TaxRate")
    private BigDecimal taxRate;

    @Column(name = "StockLevel")
    private Integer stockLevel;

    @Column(name = "ShippingCost")
    private BigDecimal shippingCost;

    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;

    @Column(name = "EmployeePerformance")
    private Integer employeePerformance;

    @Column(name = "LogisticsEfficiency")
    private BigDecimal logisticsEfficiency;

    @Column(name = "SupplierRating")
    private BigDecimal supplierRating;

    @Column(name = "ITSecurityRating")
    private BigDecimal itSecurityRating;

    @Column(name = "RefundAmount")
    private BigDecimal refundAmount;

    @Column(name = "QualityAssuranceScore")
    private BigDecimal qualityAssuranceScore;

    @Column(name = "PromotionDiscount")
    private BigDecimal promotionDiscount;

    @Column(name = "FinancialStabilityIndex")
    private BigDecimal financialStabilityIndex;

    @Column(name = "RiskCategory")
    private String riskCategory;

    @Column(name = "EcoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Integer getEmployeePerformance() {
        return employeePerformance;
    }

    public void setEmployeePerformance(Integer employeePerformance) {
        this.employeePerformance = employeePerformance;
    }

    public BigDecimal getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(BigDecimal logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public BigDecimal getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(BigDecimal supplierRating) {
        this.supplierRating = supplierRating;
    }

    public BigDecimal getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(BigDecimal itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(BigDecimal qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    public BigDecimal getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(BigDecimal promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public BigDecimal getFinancialStabilityIndex() {
        return financialStabilityIndex;
    }

    public void setFinancialStabilityIndex(BigDecimal financialStabilityIndex) {
        this.financialStabilityIndex = financialStabilityIndex;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public BigDecimal getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(BigDecimal ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }
}

package hello.repository;

import hello.entity.TempItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempItemRepository extends JpaRepository<TempItem, Integer> {
}

package hello.service;

import hello.entity.TempItem;
import hello.repository.TempItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public void insertTempItems(Integer orderId, String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlData);
            TempItem tempItem = new TempItem();
            tempItem.setOrderId(orderId);
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            // Parse XML and set properties of tempItem
            tempItemRepository.save(tempItem);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing XML data", e);
        }
    }
}

package hello.controller;

import hello.service.TempItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temp-items")
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping
    public ResponseEntity<Void> createTempItem(@RequestParam Integer orderId, @RequestParam String xmlData) {
        tempItemService.insertTempItems(orderId, xmlData);
        return ResponseEntity.ok().build();
    }
}