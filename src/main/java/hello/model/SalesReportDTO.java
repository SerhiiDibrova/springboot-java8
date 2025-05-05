package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SalesReportDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer orderId;

    @JsonProperty("manager_id")
    private Integer managerId;

    @NotNull
    @JsonProperty("report_date")
    private LocalDateTime reportDate;

    @NotNull
    @JsonProperty("total_sales")
    private BigDecimal totalSales;

    @JsonProperty("audit_data")
    private List<AuditDataDTO> auditData;

    public SalesReportDTO(Integer orderId, Integer managerId, LocalDateTime reportDate, BigDecimal totalSales, List<AuditDataDTO> auditData) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.reportDate = reportDate;
        this.totalSales = totalSales;
        this.auditData = auditData;
    }
}