package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "#WarehouseReport")
public class WarehouseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "WarehouseId")
    private Long warehouseId;

    @NotNull
    @Column(name = "WarehouseName")
    private String warehouseName;

    @NotNull
    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;

    @NotNull
    @Column(name = "OrderId")
    private Long orderId;

    @NotNull
    @Column(name = "RegionName")
    private String regionName;

    @NotNull
    @Column(name = "BranchName")
    private String branchName;

    @NotNull
    @Column(name = "VendorName")
    private String vendorName;

    @NotNull
    @Column(name = "ProductCategory")
    private String productCategory;

    @NotNull
    @Column(name = "StockLevel")
    private Integer stockLevel;

    @NotNull
    @Column(name = "LogisticsEfficiency")
    private Double logisticsEfficiency;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Double getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(Double logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }
}

package hello.repository;

import hello.entity.WarehouseReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
}

package hello.service;

import hello.entity.WarehouseReport;
import hello.repository.WarehouseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WarehouseReportService {

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Transactional
    public WarehouseReport save(WarehouseReport warehouseReport) {
        return warehouseReportRepository.save(warehouseReport);
    }

    public List<WarehouseReport> findAll() {
        return warehouseReportRepository.findAll();
    }
}

package hello.controller;

import hello.entity.WarehouseReport;
import hello.service.WarehouseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse-reports")
public class WarehouseReportController {

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PostMapping
    public ResponseEntity<WarehouseReport> createWarehouseReport(@RequestBody WarehouseReport warehouseReport) {
        WarehouseReport createdReport = warehouseReportService.save(warehouseReport);
        return ResponseEntity.ok(createdReport);
    }

    @GetMapping
    public ResponseEntity<List<WarehouseReport>> getAllWarehouseReports() {
        List<WarehouseReport> reports = warehouseReportService.findAll();
        return ResponseEntity.ok(reports);
    }
}