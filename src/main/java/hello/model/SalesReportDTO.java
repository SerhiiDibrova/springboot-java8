

package hello.model;

import java.util.Objects;

public class SalesReportDTO {
    private String orderId;
    private String managerId;
    private String xmlData;
    private boolean isAuditNeeded;
    private String salesData;
    private String warehouseReport;

    public SalesReportDTO(String orderId, String managerId, String xmlData, boolean isAuditNeeded, String salesData, String warehouseReport) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.xmlData = xmlData;
        this.isAuditNeeded = isAuditNeeded;
        this.salesData = salesData;
        this.warehouseReport = warehouseReport;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }

    public boolean isAuditNeeded() {
        return isAuditNeeded;
    }

    public void setAuditNeeded(boolean auditNeeded) {
        isAuditNeeded = auditNeeded;
    }

    public String getSalesData() {
        return salesData;
    }

    public void setSalesData(String salesData) {
        this.salesData = salesData;
    }

    public String getWarehouseReport() {
        return warehouseReport;
    }

    public void setWarehouseReport(String warehouseReport) {
        this.warehouseReport = warehouseReport;
    }

    @Override
    public String toString() {
        return "SalesReportDTO{" +
                "orderId='" + orderId + '\'' +
                ", managerId='" + managerId + '\'' +
                ", xmlData='" + xmlData + '\'' +
                ", isAuditNeeded=" + isAuditNeeded +
                ", salesData='" + salesData + '\'' +
                ", warehouseReport='" + warehouseReport + '\'' +
                '}';
    }

    public String toDTOString() {
        return "orderId: " + orderId + ", managerId: " + managerId + ", xmlData: " + xmlData + ", isAuditNeeded: " + isAuditNeeded + ", salesData: " + salesData + ", warehouseReport: " + warehouseReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesReportDTO that = (SalesReportDTO) o;
        return isAuditNeeded == that.isAuditNeeded &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(managerId, that.managerId) &&
                Objects.equals(xmlData, that.xmlData) &&
                Objects.equals(salesData, that.salesData) &&
                Objects.equals(warehouseReport, that.warehouseReport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, managerId, xmlData, isAuditNeeded, salesData, warehouseReport);
    }

    public boolean compare(SalesReportDTO other) {
        return this.equals(other);
    }
}