

package hello.model;

import java.math.BigDecimal;

/**
 * Data Transfer Object for TempItemEntity.
 */
public class TemporaryItemDTO {
    private BigDecimal id;
    private String name;
    private BigDecimal quantity;
    private BigDecimal price;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TemporaryItemDTO{" +
                "id=" + (id != null ? id.toString() : "null") +
                ", name='" + (name != null ? name : "null") + '\'' +
                ", quantity=" + (quantity != null ? quantity.toString() : "null") +
                ", price=" + (price != null ? price.toString() : "null") +
                '}';
    }
}