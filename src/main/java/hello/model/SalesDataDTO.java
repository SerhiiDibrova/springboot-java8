package hello.model;

import lombok.Data;

@Data
public class SalesDataDTO {
    private Long id;
    private String productName;
    private Integer quantitySold;
    private Double totalRevenue;
    private String saleDate;
    private String customerName;
}