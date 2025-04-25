package hello.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "SalesReport")
public class SalesReportModel {
    
    @Id
    private Long id;
    private String productName;
    private Integer quantitySold;
    private Double totalRevenue;
    private String salesDate;
    private String region;
    private String customerName;
    private String paymentMethod;
    private Double discountApplied;
    private String salesRepresentative;
}