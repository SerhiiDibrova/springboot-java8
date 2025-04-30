package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "#TempItems")
public class TempItem {

    @Id
    @NotNull
    @Column(name = "orderId")
    private Integer orderId;

    @NotNull
    @Column(name = "configId")
    private Integer configId;

    @Column(name = "additionalField1")
    private String additionalField1;

    @Column(name = "additionalField2")
    private String additionalField2;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getAdditionalField1() {
        return additionalField1;
    }

    public void setAdditionalField1(String additionalField1) {
        this.additionalField1 = additionalField1;
    }

    public String getAdditionalField2() {
        return additionalField2;
    }

    public void setAdditionalField2(String additionalField2) {
        this.additionalField2 = additionalField2;
    }
}