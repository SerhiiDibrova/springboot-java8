package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SalesReport", uniqueConstraints = @UniqueConstraint(columnNames = {"order_id"}))
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "manager_id")
    private Integer managerId;

    @NotNull
    @Size(max = 255)
    @Column(name = "xml_data", nullable = false)
    private String xmlData;

    @NotNull
    @Column(name = "is_audit_needed", nullable = false)
    private Boolean isAuditNeeded;

    @ManyToOne
    @JoinColumn(name = "manager_id", insertable = false, updatable = false)
    private Manager manager;

    public SalesReport() {
        this.isAuditNeeded = false;
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}