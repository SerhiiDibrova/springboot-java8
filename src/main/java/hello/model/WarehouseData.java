package hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WarehouseData {
    
    @Id
    private Long orderId;
    private String inventoryDetails;
    private String warehouseDetails;

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
}