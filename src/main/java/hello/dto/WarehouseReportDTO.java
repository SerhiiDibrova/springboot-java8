package hello.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WarehouseReportDTO {
    
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String reportName;

    @NotNull
    private String createdDate;

    @NotNull
    private Long warehouseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}