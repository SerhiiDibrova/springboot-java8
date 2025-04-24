

package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class SalesReportEntity {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "xml_data")
    private String xmlData;

    @Column(name = "is_audit_needed")
    private Boolean isAuditNeeded;

    public SalesReportEntity() {}

    public SalesReportEntity(Long orderId, Long managerId, String xmlData, Boolean isAuditNeeded) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.xmlData = xmlData;
        this.isAuditNeeded = isAuditNeeded = isAuditNeeded;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }

    public Boolean getIsAuditNeeded() {
        return isAuditNeeded;
    }

    public void setIsAuditNeeded(Boolean isAuditNeeded) {
        this.isAuditNeeded = isAuditNeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesReportEntity that = (SalesReportEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(managerId, that.managerId) &&
                Objects.equals(xmlData, that.xmlData) &&
                Objects.equals(isAuditNeeded, that.isAuditNeeded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, managerId, xmlData, isAuditNeeded);
    }

    @Override
    public String toString() {
        return "SalesReportEntity{" +
                "orderId=" + orderId +
                ", managerId=" + managerId +
                ", xmlData='" + xmlData + '\'' +
                ", isAuditNeeded=" + isAuditNeeded +
                '}';
    }
}