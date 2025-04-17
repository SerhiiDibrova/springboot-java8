

package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sales_data")
public class SalesDataEntity {

    @Id
    @GeneratedValue
    @Column(name = "salesId")
    private Long salesId;

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "salesAmount")
    private Double salesAmount;

    @Column(name = "productCode")
    private String productCode;

    @Column(name = "productName")
    private String productName;

    @Column(name = "salesDate")
    private java.sql.Date salesDate;

    @Column(name = "salesRegion")
    private String salesRegion;

    @Column(name = "salesCountry")
    private String salesCountry;

    public Long getSalesId() {
        return salesId;
    }

    public void setSalesId(Long salesId) {
        this.salesId = salesId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public java.sql.Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(java.sql.Date salesDate) {
        this.salesDate = salesDate;
    }

    public String getSalesRegion() {
        return salesRegion;
    }

    public void setSalesRegion(String salesRegion) {
        this.salesRegion = salesRegion;
    }

    public String getSalesCountry() {
        return salesCountry;
    }

    public void setSalesCountry(String salesCountry) {
        this.salesCountry = salesCountry;
    }
}