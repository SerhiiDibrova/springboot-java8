package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Index;

@Entity
@Table(name = "#TempItems", indexes = @Index(name = "idx_order_id", columnList = "order_id"))
public class TempItem {

    @Id
    @GeneratedValue
    @Column(name = "order_id", nullable = false)
    @NotNull
    private Integer orderId;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    private CustomConfig customConfig;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    private LegacyConfig legacyConfig;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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