package hello.model;

import java.math.BigDecimal;

public class TempItemDTO {
    private Integer itemId;
    private Integer orderId;
    private Integer quantity;
    private BigDecimal price;

    public TempItemDTO() {
    }

    public TempItemDTO(Integer itemId, Integer orderId, Integer quantity, BigDecimal price) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}