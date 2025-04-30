package hello.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesReportRequest {
    
    @NotNull
    @JsonProperty("orderId")
    private Integer orderId;
    
    @JsonProperty("managerId")
    private Integer managerId;
    
    @NotNull
    @JsonProperty("xmlData")
    private String xmlData;
    
    @JsonProperty("isAuditNeeded")
    private Boolean isAuditNeeded = false;

    public SalesReportRequest() {
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
}