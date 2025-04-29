package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReportDTO {

    @NotNull
    private Long id;

    @NotNull
    private Integer orderId;

    @NotNull
    private BigDecimal totalSalesAmount;

    @NotNull
    private LocalDate reportDate;

    public SalesReportDTO() {
    }

    public SalesReportDTO(Long id, Integer orderId, BigDecimal totalSalesAmount, LocalDate reportDate) {
        this.id = id;
        this.orderId = orderId;
        this.totalSalesAmount = totalSalesAmount;
        this.reportDate = reportDate;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("orderId")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("totalSalesAmount")
    public BigDecimal getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(BigDecimal totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    @JsonProperty("reportDate")
    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }
}