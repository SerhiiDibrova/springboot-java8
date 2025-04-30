package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class SalesReportRequest {

    @NotNull
    @JsonProperty("reportName")
    private String reportName;

    @NotNull
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    @JsonProperty("startDate")
    private String startDate;

    @NotNull
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    @JsonProperty("endDate")
    private String endDate;

    @NotNull
    @JsonProperty("totalSales")
    private BigDecimal totalSales;

    @Size(max = 255)
    @JsonProperty("description")
    private String description;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}