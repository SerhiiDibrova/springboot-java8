package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "#TempItems")
public class TempItem {

    @Id
    @NotNull
    @Column(name = "orderId", nullable = false)
    private Integer orderId;

    @NotNull
    @Size(max = 255)
    @Column(name = "itemName", nullable = false)
    private String itemName;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "custom_config_id", nullable = false)
    private CustomConfig customConfig;

    @ManyToOne
    @JoinColumn(name = "legacy_config_id", nullable = false)
    private LegacyConfig legacyConfig;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CustomConfig getCustomConfig() {
        return customConfig;
    }

    public void setCustomConfig(CustomConfig customConfig) {
        this.customConfig = customConfig;
    }

    public LegacyConfig getLegacyConfig() {
        return legacyConfig;
    }

    public void setLegacyConfig(LegacyConfig legacyConfig) {
        this.legacyConfig = legacyConfig;
    }
}