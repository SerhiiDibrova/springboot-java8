package hello.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SalesReportDTO {
    private Long id;
    private String productName;
    private BigDecimal salesAmount;
    private Date salesDate;
    private Integer quantitySold;
}