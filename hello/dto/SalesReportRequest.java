package hello.dto;

public class SalesReportRequest {
    private String orderId;
    private String managerId;
    private String xmlData;
    private boolean auditNeeded;

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
        return auditNeeded;
    }

    public void setAuditNeeded(boolean auditNeeded) {
        this.auditNeeded = auditNeeded;
    }
}