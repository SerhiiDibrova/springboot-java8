package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Warehouses", uniqueConstraints = @UniqueConstraint(columnNames = "warehouse_name"))
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    @NotNull
    private Long warehouseId;

    @Column(name = "warehouse_name", nullable = false)
    @NotNull
    @Size(max = 100)
    private String warehouseName;

    @Column(nullable = false)
    @NotNull
    private Integer warehouseCapacity;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "warehouse")
    private List<Inventory> inventory;

    @OneToMany(mappedBy = "warehouse")
    private List<WarehouseReport> warehouseReports;

    @OneToMany(mappedBy = "warehouse")
    private List<Orders> orders;

    @OneToMany(mappedBy = "warehouse")
    private List<Legacy_Logistics> legacyLogistics;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public List<WarehouseReport> getWarehouseReports() {
        return warehouseReports;
    }

    public void setWarehouseReports(List<WarehouseReport> warehouseReports) {
        this.warehouseReports = warehouseReports;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Legacy_Logistics> getLegacyLogistics() {
        return legacyLogistics;
    }

    public void setLegacyLogistics(List<Legacy_Logistics> legacyLogistics) {
        this.legacyLogistics = legacyLogistics;
    }
}