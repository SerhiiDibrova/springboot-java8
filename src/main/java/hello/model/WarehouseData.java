package hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class WarehouseData {
    
    @Id
    private Long orderId;
    private String inventoryDetails;
    private String warehouseDetails;
    private String orderStatus;
    private String customerName;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getInventoryDetails() {
        return inventoryDetails;
    }

    public void setInventoryDetails(String inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }

    public String getWarehouseDetails() {
        return warehouseDetails;
    }

    public void setWarehouseDetails(String warehouseDetails) {
        this.warehouseDetails = warehouseDetails;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}