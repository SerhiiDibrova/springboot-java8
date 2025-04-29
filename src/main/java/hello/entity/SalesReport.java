package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
@Table(name = "sales_report")
public class SalesReport {

    @Id
    @Column(name = "report_id")
    private Long reportId;

    @NotNull
    @Positive
    @Column(name = "sales_amount")
    private Double salesAmount;

    @NotNull
    @PastOrPresent
    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "product_id")
    private Long productId;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}