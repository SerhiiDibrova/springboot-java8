package hello.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class SalesReportDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String productName;

    @NotNull
    @Positive
    private Integer quantitySold;

    @NotNull
    @Positive
    private Double totalRevenue;

    @NotNull
    private String salesDate;

    public SalesReportDTO() {
    }

    public SalesReportDTO(Long id, String productName, Integer quantitySold, Double totalRevenue, String salesDate) {
        if (productName == null || productName.isEmpty() || productName.length() > 100) {
            throw new IllegalArgumentException("Invalid product name");
        }
        if (quantitySold == null || quantitySold <= 0) {
            throw new IllegalArgumentException("Invalid quantity sold");
        }
        if (totalRevenue == null || totalRevenue <= 0) {
            throw new IllegalArgumentException("Invalid total revenue");
        }
        if (salesDate == null) {
            throw new IllegalArgumentException("Sales date cannot be null");
        }
        this.id = id;
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalRevenue = totalRevenue;
        this.salesDate = salesDate;
    }
}