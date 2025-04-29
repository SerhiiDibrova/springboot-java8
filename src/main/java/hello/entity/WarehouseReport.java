package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "WarehouseReport")
public class WarehouseReport {

    @Id
    @Column(name = "WarehouseId")
    @NotNull
    private Long warehouseId;

    @Column(name = "WarehouseName")
    @NotNull
    @Size(max = 255)
    private String warehouseName;

    @Column(name = "WarehouseCapacity")
    @NotNull
    private Integer warehouseCapacity;

    @Column(name = "OrderId")
    @NotNull
    private Long orderId;

    @Column(name = "RegionName")
    @NotNull
    @Size(max = 255)
    private String regionName;

    @Column(name = "BranchName")
    @NotNull
    @Size(max = 255)
    private String branchName;

    @Column(name = "VendorName")
    @NotNull
    @Size(max = 255)
    private String vendorName;

    @Column(name = "ProductCategory")
    @NotNull
    @Size(max = 255)
    private String productCategory;

    @Column(name = "StockLevel")
    @NotNull
    private Integer stockLevel;

    @Column(name = "LogisticsEfficiency")
    @NotNull
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

@Service
public class WarehouseReportService {

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    public WarehouseReport save(WarehouseReport warehouseReport) {
        return warehouseReportRepository.save(warehouseReport);
    }
}