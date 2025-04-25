package hello.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SalesReportRequestModel {
    private String orderId;
    private String managerId;
    private String xmlData;
    private boolean isAuditNeeded;

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

    public void setAuditNeeded(boolean isAuditNeeded) {
        this.isAuditNeeded = isAuditNeeded;
    }
}