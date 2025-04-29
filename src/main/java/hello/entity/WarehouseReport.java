package hello.entity;

import java.util.List;
import java.util.Date;

public class WarehouseReport {
    private String reportId;
    private String warehouseId;
    private List<String> items;
    private Date generatedDate;

    public WarehouseReport(String reportId, String warehouseId, List<String> items, Date generatedDate) {
        this.reportId = reportId;
        this.warehouseId = warehouseId;
        this.items = items;
        this.generatedDate = generatedDate;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String generateReportSummary() {
        return "Warehouse Report Summary: " +
                "Report ID: " + reportId + ", " +
                "Warehouse ID: " + warehouseId + ", " +
                "Items Count: " + (items != null ? items.size() : 0) + ", " +
                "Generated Date: " + generatedDate;
    }

    @Override
    public String toString() {
        return "WarehouseReport{" +
                "reportId='" + reportId + '\'' +
                ", warehouseId='" + warehouseId + '\'' +
                ", items=" + items +
                ", generatedDate=" + generatedDate +
                '}';
    }
}