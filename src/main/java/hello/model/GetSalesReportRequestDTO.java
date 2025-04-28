package hello.model;

public class GetSalesReportRequestDTO {
    private Integer orderId;
    private Integer managerId;
    private String xmlData;
    private Boolean isAuditNeeded;

    public GetSalesReportRequestDTO(Integer orderId, Integer managerId, String xmlData, Boolean isAuditNeeded) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.xmlData = xmlData;
        this.isAuditNeeded = isAuditNeeded;
    }

    public Integer getOrderId() { return orderId; }
    public Integer getManagerId() { return managerId; }
    public String getXmlData() { return xmlData; }
    public Boolean getIsAuditNeeded() { return isAuditNeeded; }
    
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }
    public void setXmlData(String xmlData) { this.xmlData = xmlData; }
    public void setIsAuditNeeded(Boolean isAuditNeeded) { this.isAuditNeeded = isAuditNeeded; }
}