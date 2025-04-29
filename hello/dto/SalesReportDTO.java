package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class SalesReportDTO {

    @NotNull
    @JsonProperty("orderId")
    private Integer orderId;

    @NotNull
    @JsonProperty("managerId")
    private Integer managerId;

    @NotNull
    @JsonProperty("salesFigures")
    private BigDecimal salesFigures;

    @Size(max = 255)
    @JsonProperty("description")
    private String description;

    public SalesReportDTO() {
    }

    public SalesReportDTO(Integer orderId, Integer managerId, BigDecimal salesFigures, String description) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.salesFigures = salesFigures;
        this.description = description;
    }

    public static SalesReportDTO fromEntity(SalesReport entity) {
        return new SalesReportDTO(
            entity.getOrderId(),
            entity.getManagerId(),
            entity.getSalesFigures(),
            entity.getDescription()
        );
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public BigDecimal getSalesFigures() {
        return salesFigures;
    }

    public void setSalesFigures(BigDecimal salesFigures) {
        this.salesFigures = salesFigures;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}