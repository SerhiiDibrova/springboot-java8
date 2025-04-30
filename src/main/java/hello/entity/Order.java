package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    @NotNull
    private Integer orderId;

    @Column(name = "customer_id", nullable = false)
    @NotNull
    private Integer customerId;

    @Column(name = "order_date", nullable = false)
    @NotNull
    private LocalDateTime orderDate;

    @Column(name = "status", nullable = false, length = 20)
    @NotNull
    @Size(max = 20)
    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Inventory> inventories;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<WarehouseReport> warehouseReports;

    public Order() {
        this.status = "Pending";
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public List<WarehouseReport> getWarehouseReports() {
        return warehouseReports;
    }

    public void setWarehouseReports(List<WarehouseReport> warehouseReports) {
        this.warehouseReports = warehouseReports;
    }
}