package hello.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private String customerSegment;

    @Column(nullable = false)
    private String regionName;

    @Column
    private BigDecimal financialMetric1;

    @Column
    private BigDecimal financialMetric2;

    @Column
    private BigDecimal financialMetric3;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getFinancialMetric1() {
        return financialMetric1;
    }

    public void setFinancialMetric1(BigDecimal financialMetric1) {
        this.financialMetric1 = financialMetric1;
    }

    public BigDecimal getFinancialMetric2() {
        return financialMetric2;
    }

    public void setFinancialMetric2(BigDecimal financialMetric2) {
        this.financialMetric2 = financialMetric2;
    }

    public BigDecimal getFinancialMetric3() {
        return financialMetric3;
    }

    public void setFinancialMetric3(BigDecimal financialMetric3) {
        this.financialMetric3 = financialMetric3;
    }
}