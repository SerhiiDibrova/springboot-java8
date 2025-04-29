package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "#WarehouseReport")
public class WarehouseReport {

    @Id
    @Column(name = "WarehouseId")
    private Long warehouseId;

    @Column(name = "WarehouseName")
    private String warehouseName;

    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;

    @Column(name = "OrderId")
    private Long orderId;

    @Column(name = "RegionName")
    private String regionName;

    @Column(name = "BranchName")
    private String branchName;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "ProductCategory")
    private String productCategory;

    @Column(name = "StockLevel")
    private Integer stockLevel;

    @Column(name = "LogisticsEfficiency")
    private Double logisticsEfficiency;

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
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {
}

package hello.service;

import hello.entity.WarehouseReport;
import hello.repository.WarehouseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseReportService {

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    public List<WarehouseReport> getAllReports() {
        return warehouseReportRepository.findAll();
    }

    public WarehouseReport saveReport(WarehouseReport report) {
        return warehouseReportRepository.save(report);
    }

    public void deleteReport(Long id) {
        warehouseReportRepository.deleteById(id);
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

    @GetMapping
    public List<WarehouseReport> getAllReports() {
        return warehouseReportService.getAllReports();
    }

    @PostMapping
    public WarehouseReport createReport(@RequestBody WarehouseReport report) {
        return warehouseReportService.saveReport(report);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        warehouseReportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}