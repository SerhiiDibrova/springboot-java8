package hello.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String productName;
    private int quantitySold;
    private BigDecimal totalRevenue;
    private String saleDate;
    private String customerName;
    private String transactionId;
}