package hello.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SalesDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String productName;
    private int quantitySold;
    private BigDecimal totalRevenue;
    private String saleDate;
}