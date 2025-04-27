package hello.model;

import lombok.Data;

@Data
public class WarehouseDataModel {
    private int orderId;
    private String itemName;
    private int quantity;
    private String warehouseLocation;
}